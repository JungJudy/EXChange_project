package Exchange;

import java.io.IOException;

public class MoneyExchange {
	/*
	 * 210422
	 * ȯ���� �־� ���� Ŭ������ �ҷ����� �޼ҵ带 ������ Ŭ����
	 * @kopo37(������)
	 */
	public void moneyEx() throws IOException {		
		//�������� ����� ExchangeTyoeŬ���� ����. �ؿ� �ݺ������� new ���ش�. (�ֳ��ϸ� ���� ȯ���� �� ������ �ʱ�ȭ�� �ؼ� �� ������ ��������)
		ExchangeType exType;
		
		//Ŭ���� [ProcessingClass,InputFromConsoleClass,FileWriteClass]�� �ҷ����� ���� ��ü����
		ProcessingClass pc = new ProcessingClass();
		InputFromConsoleClass inputConsole = new InputFromConsoleClass();
		FileWriteClass fwc = new FileWriteClass();
		
		//����� ������ ����κ��� ���(�ѹ��� ����ؾ��ϱ� ������ �ݺ��� ������ ����)
		fwc.headerWrite(); 

		//do�� �ϴ� �����ϰ� �ؿ� while���� type�� 0�϶� ���߰� �Ѵ�. �̷��� �ؾ� type�� 0�϶��� �ϴ� ����.
		while (true) {
			//new ExchangeType();�� ���⼭ ���ִ� ������ ȯ���� �� �� ���� �ʱ�ȭ�ϱ� ����.
			exType = new ExchangeType(); 

			//input���� ������ �͵��� �ѹ��� �����Ѵ�.
			inputConsole.inputAll(exType);
			
			//input���� ���� Ÿ���� 0�̸� �ݺ����� �����Ų��.
			if(exType.type == 0) {
				System.out.println("����");
				break;
			}
			
			//Ÿ�Կ� ����, ȯ�� ������ ��ģ��.
			if(exType.type == ConstValueClass.EX_TYPE_USD) {
				pc.exchangeUSD(exType, ConstValueClass.EX_RATE_USD);
			} else if(exType.type == ConstValueClass.EX_TYPE_EUR) {
				pc.exchangeEUR(exType, ConstValueClass.EX_RATE_EUR);
			} else if(exType.type == ConstValueClass.EX_TYPE_JPY) {
				pc.exchangeJPY(exType, ConstValueClass.EX_RATE_JPY);
			}
			
			//ProcessingClass�� returnWon�޼ҵ带 ���� �Ž������� ���Ѵ�.
			pc.returnWon(exType);
			
			//ȯ�� ����� ���Ͽ� ����Ѵ�.
			fwc.dataWrite(exType); 
		} 
		//FileWriteClass�� fileClass�޼ҵ带 ���� FileWriter�� close���ش�.
		fwc.fileClose(); 
	}
}
