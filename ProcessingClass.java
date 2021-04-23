package Exchange;



public class ProcessingClass {
OutputClass outClass = null;
ProcessingClass() { //생성자
		outClass = new OutputClass();
	}
	//USD 환전 과정
	public void exchangeUSD(ExchangeType exType, double EX_RATE_USD) { //달러 환전 과정
		double exchangeResult = exType.won / EX_RATE_USD ; //환전 결과(소수점까지)
		int usd = (int)exchangeResult; //환전한 결과에 (int)를 붙여 정수형으로 만든다(실제 받는 USD달러)
		exType.cw = exType.won - (usd * EX_RATE_USD); //원화 거스름돈(소수점까지)

		int remainToCount = usd; //큰 단위부터 나누고 나머지돈
		int[] USDunits = {100, 50, 20, 10, 5, 2, 1}; 
		int[] USDcount = new int[USDunits.length]; //각 단위의 돈이 몇장인지 세는 배열

		for (int i = 0; i < USDunits.length; i++) {
			USDcount[i] = remainToCount/USDunits[i];
			remainToCount = remainToCount % USDunits[i]; //outClass의 PrintUSD메소드를 따른다
		}
		//outputClass에서 출력하기위해 메소드를 따라 환전의 결과값을 넣어준다.
		outClass.printUSD(exchangeResult, usd, USDunits, USDcount); //outClass의 printUSD메소드를 따른다
		
		//파일에 기록하기위해 환전의 결과에 환전받은 usd달러를 기록
		exType.ex_result = usd;

	}
	
	//EUR 환전 과정
	public void exchangeEUR(ExchangeType exType, double EX_RATE_EUR) {
		double exchangeResult = exType.won / EX_RATE_EUR ; //유로 환율로 계산된 값(소수점까지)
		
		//환전받을 유로는 환율로 계산된 환전 결과에 (int)를 씌어 내림처리 해주고, 마지막에 %5를 해준 값을 빼준다.
		//왜냐하면 유로의 지폐단위는 5유로까지라서 int로 내림처리한 정수 유로에 5로 나눈 나머지를 빼줘야 동전단위가 나오지 않는다.
		int eur = (int)exchangeResult - ((int)exchangeResult % 5); 
		exType.cw = exType.won - eur * EX_RATE_EUR; //원화 거스름돈(소수점까지)

		int remainToCount = eur; //큰 단위부터 나누고 나머지돈
		int[] EURunits = {500, 200, 100, 50, 20, 10, 5};
		int[] EURcount = new int[EURunits.length]; //각 단위의 돈이 몇장인지 세는 배열

		for (int i = 0; i < EURunits.length; i++) {
			EURcount[i] = remainToCount / EURunits[i];
			remainToCount = remainToCount % EURunits[i];
		}
		//OuputClass에서 출력하기 위해 메소드를 따라 환전의 결과값을 넣는다.
		outClass.printEUR(exchangeResult, eur, EURunits, EURcount);
		
		//파일에 기록하기위해 환전의 결과에 환전받는 eur달러를 기록
		exType.ex_result = eur;

	} 
	//JPY 환전 과정
	public void exchangeJPY(ExchangeType exType, double EX_RATE_JPY) {
		double exchangeResult = exType.won / EX_RATE_JPY ; //엔화 환율로 계산된 값(소수점까지)
		
		//환전받을 엔화는 환율로 계산된 환전 결과에 (int)를 씌어 내림처리 해주고, 마지막에 %1000를 해준 값을 빼준다.
		//왜냐하면 엔화의 지폐단위는 1000엔까지라서 int로 내림처리한 정수 엔화에 1000으로 나눈 나머지를 빼줘야 동전단위가 나오지 않는다.
		int jpy = (int)exchangeResult - ((int)exchangeResult % 1000);
		exType.cw = exType.won - jpy * EX_RATE_JPY; //원화 거스름돈(소수점까지)

		int remainToCount = jpy; //큰 단위부터 나누고 나머지돈
		int[] JPYunits = {10000, 5000, 2000, 1000};
		int[] JPYcount = new int[JPYunits.length]; //각 단위의 돈이 몇장인지 세는 배열

		for (int i = 0; i < JPYunits.length; i++) {
			JPYcount[i] = remainToCount / JPYunits[i];
			remainToCount = remainToCount % JPYunits[i]; //나머지돈을 단위로 나누고난 나머지 돈 대입
		}
		//OutputClass에서 출력하기위해 메소드를 따라 환전의 결과값을 넣어준다.
		outClass.printJPY(exchangeResult, jpy, JPYunits, JPYcount);
		
		//파일에 기록하기위해 환전의 결과에 환전받은 eur달러를 기록
		exType.ex_result = jpy;
	}
	//거스름돈 계싼
	public void returnWon(ExchangeType exType) {	
		//실제로 받는 거스름돈 계산. 소수점단위의 거스름돈을 10으로 나누고 10을 곱하면 1의자리가 버림처리 된다. 그리고 int로 형변환
		exType.returnwon = (int)(exType.cw / 10) * 10; 
		
		
		int remainToCount = exType.returnwon; //큰 단위부터 나누고 나머지돈
		int[] wonUnits = {10000, 5000, 1000, 500, 100, 10};
		int[] wonCount = new int[wonUnits.length]; //각 단위의 돈이 몇장인지 세는 배열

		for (int i = 0; i < wonUnits.length; i++) {
			wonCount[i] = remainToCount/wonUnits[i];
			remainToCount = remainToCount % wonUnits[i]; //나머지돈을 단위로 나누고난 나머지 돈 대입
		}
		//OutputClass에서 출력하기위해 메소드를 따라 환전의 결과값을 넣어준다.
		outClass.printWon(exType.cw, exType.returnwon, wonUnits, wonCount);
	}

}
