package Exchange;

import java.util.Scanner;


public class InputFromConsoleClass {
	/*
	 * 210422
	 * 환전할 원화와, 타입의 변수를 받는 클래스
	 * @kopo37(정현정)
	 */
Scanner scanner = null;//스캐너 선언
	public InputFromConsoleClass() {//생성자
		scanner = new Scanner(System.in); //스캐너 불러오기
	}
	
	//밑의 3개의 메소드를 한번에 실행시켜주는 메소드
	public ExchangeType inputAll(ExchangeType exType) {
		inputType(exType);
		inputWon(exType);
		exchangeType(exType);
		return exType;
	}
	//환전할 원화를 입력받는 메소드
	public void inputWon(ExchangeType exType) {
		System.out.print("#받은 원화 입력 : ");
		exType.won = scanner.nextInt();

	}
	//환전할 타입을 입력받는 메소드
	public void inputType(ExchangeType exType) {
		System.out.print("#환전할 종류 선택 (0: 종료, 1:USD, 2:EUR, 3:JPY ) ? ");
		exType.type = scanner.nextInt();
	}
	//환전할 타입을 스트링으로 넣어주는 메소드
	public void exchangeType(ExchangeType exType) {
		if (exType.type == ConstValueClass.EX_TYPE_USD) {
			exType.typeStr = "USD";
		} else if (exType.type == ConstValueClass.EX_TYPE_EUR) {
			exType.typeStr = "EUR";
		} else if (exType.type == ConstValueClass.EX_TYPE_JPY) {
			exType.typeStr = "JPY";
		} 
	}
}
