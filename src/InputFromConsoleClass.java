package Exchange;

import java.util.Scanner;


public class InputFromConsoleClass {
	/*
	 * 210422
	 * ȯ���� ��ȭ��, Ÿ���� ������ �޴� Ŭ����
	 * @kopo37(������)
	 */
Scanner scanner = null;//��ĳ�� ����
	public InputFromConsoleClass() {//������
		scanner = new Scanner(System.in); //��ĳ�� �ҷ�����
	}
	
	//���� 3���� �޼ҵ带 �ѹ��� ��������ִ� �޼ҵ�
	public ExchangeType inputAll(ExchangeType exType) {
		inputType(exType);
		inputWon(exType);
		exchangeType(exType);
		return exType;
	}
	//ȯ���� ��ȭ�� �Է¹޴� �޼ҵ�
	public void inputWon(ExchangeType exType) {
		System.out.print("#���� ��ȭ �Է� : ");
		exType.won = scanner.nextInt();

	}
	//ȯ���� Ÿ���� �Է¹޴� �޼ҵ�
	public void inputType(ExchangeType exType) {
		System.out.print("#ȯ���� ���� ���� (0: ����, 1:USD, 2:EUR, 3:JPY ) ? ");
		exType.type = scanner.nextInt();
	}
	//ȯ���� Ÿ���� ��Ʈ������ �־��ִ� �޼ҵ�
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
