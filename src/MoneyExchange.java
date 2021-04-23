package Exchange;

import java.io.IOException;

public class MoneyExchange {
	/*
	 * 210422
	 * 환전에 있어 각종 클래스를 불러오고 메소드를 실행할 클래스
	 * @kopo37(정현정)
	 */
	public void moneyEx() throws IOException {		
		//변수들을 담아준 ExchangeTyoe클래스 선언. 밑에 반복문에서 new 해준다. (왜냐하면 새로 환전을 할 때마다 초기화를 해서 새 정보를 입히려고)
		ExchangeType exType;
		
		//클래스 [ProcessingClass,InputFromConsoleClass,FileWriteClass]를 불러오기 위한 객체선언
		ProcessingClass pc = new ProcessingClass();
		InputFromConsoleClass inputConsole = new InputFromConsoleClass();
		FileWriteClass fwc = new FileWriteClass();
		
		//결과물 파일의 헤더부분을 기록(한번만 출력해야하기 때문에 반복문 위에서 실행)
		fwc.headerWrite(); 

		//do로 일단 실행하고 밑에 while에서 type이 0일때 멈추게 한다. 이렇게 해야 type이 0일때도 일단 돈다.
		while (true) {
			//new ExchangeType();을 여기서 해주는 이유는 환전을 할 때 마다 초기화하기 위해.
			exType = new ExchangeType(); 

			//input에서 실행할 것들을 한번에 실행한다.
			inputConsole.inputAll(exType);
			
			//input에서 받은 타입이 0이면 반복문을 종료시킨다.
			if(exType.type == 0) {
				System.out.println("종료");
				break;
			}
			
			//타입에 따라서, 환전 과정을 거친다.
			if(exType.type == ConstValueClass.EX_TYPE_USD) {
				pc.exchangeUSD(exType, ConstValueClass.EX_RATE_USD);
			} else if(exType.type == ConstValueClass.EX_TYPE_EUR) {
				pc.exchangeEUR(exType, ConstValueClass.EX_RATE_EUR);
			} else if(exType.type == ConstValueClass.EX_TYPE_JPY) {
				pc.exchangeJPY(exType, ConstValueClass.EX_RATE_JPY);
			}
			
			//ProcessingClass의 returnWon메소드를 따라 거스름돈을 구한다.
			pc.returnWon(exType);
			
			//환전 결과를 파일에 기록한다.
			fwc.dataWrite(exType); 
		} 
		//FileWriteClass의 fileClass메소드를 따라 FileWriter를 close해준다.
		fwc.fileClose(); 
	}
}
