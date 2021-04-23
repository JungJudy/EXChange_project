package Exchange;



public class ProcessingClass {
OutputClass outClass = null;
ProcessingClass() { //������
		outClass = new OutputClass();
	}
	//USD ȯ�� ����
	public void exchangeUSD(ExchangeType exType, double EX_RATE_USD) { //�޷� ȯ�� ����
		double exchangeResult = exType.won / EX_RATE_USD ; //ȯ�� ���(�Ҽ�������)
		int usd = (int)exchangeResult; //ȯ���� ����� (int)�� �ٿ� ���������� �����(���� �޴� USD�޷�)
		exType.cw = exType.won - (usd * EX_RATE_USD); //��ȭ �Ž�����(�Ҽ�������)

		int remainToCount = usd; //ū �������� ������ ��������
		int[] USDunits = {100, 50, 20, 10, 5, 2, 1}; 
		int[] USDcount = new int[USDunits.length]; //�� ������ ���� �������� ���� �迭

		for (int i = 0; i < USDunits.length; i++) {
			USDcount[i] = remainToCount/USDunits[i];
			remainToCount = remainToCount % USDunits[i]; //outClass�� PrintUSD�޼ҵ带 ������
		}
		//outputClass���� ����ϱ����� �޼ҵ带 ���� ȯ���� ������� �־��ش�.
		outClass.printUSD(exchangeResult, usd, USDunits, USDcount); //outClass�� printUSD�޼ҵ带 ������
		
		//���Ͽ� ����ϱ����� ȯ���� ����� ȯ������ usd�޷��� ���
		exType.ex_result = usd;

	}
	
	//EUR ȯ�� ����
	public void exchangeEUR(ExchangeType exType, double EX_RATE_EUR) {
		double exchangeResult = exType.won / EX_RATE_EUR ; //���� ȯ���� ���� ��(�Ҽ�������)
		
		//ȯ������ ���δ� ȯ���� ���� ȯ�� ����� (int)�� ���� ����ó�� ���ְ�, �������� %5�� ���� ���� ���ش�.
		//�ֳ��ϸ� ������ ��������� 5���α����� int�� ����ó���� ���� ���ο� 5�� ���� �������� ����� ���������� ������ �ʴ´�.
		int eur = (int)exchangeResult - ((int)exchangeResult % 5); 
		exType.cw = exType.won - eur * EX_RATE_EUR; //��ȭ �Ž�����(�Ҽ�������)

		int remainToCount = eur; //ū �������� ������ ��������
		int[] EURunits = {500, 200, 100, 50, 20, 10, 5};
		int[] EURcount = new int[EURunits.length]; //�� ������ ���� �������� ���� �迭

		for (int i = 0; i < EURunits.length; i++) {
			EURcount[i] = remainToCount / EURunits[i];
			remainToCount = remainToCount % EURunits[i];
		}
		//OuputClass���� ����ϱ� ���� �޼ҵ带 ���� ȯ���� ������� �ִ´�.
		outClass.printEUR(exchangeResult, eur, EURunits, EURcount);
		
		//���Ͽ� ����ϱ����� ȯ���� ����� ȯ���޴� eur�޷��� ���
		exType.ex_result = eur;

	} 
	//JPY ȯ�� ����
	public void exchangeJPY(ExchangeType exType, double EX_RATE_JPY) {
		double exchangeResult = exType.won / EX_RATE_JPY ; //��ȭ ȯ���� ���� ��(�Ҽ�������)
		
		//ȯ������ ��ȭ�� ȯ���� ���� ȯ�� ����� (int)�� ���� ����ó�� ���ְ�, �������� %1000�� ���� ���� ���ش�.
		//�ֳ��ϸ� ��ȭ�� ��������� 1000�������� int�� ����ó���� ���� ��ȭ�� 1000���� ���� �������� ����� ���������� ������ �ʴ´�.
		int jpy = (int)exchangeResult - ((int)exchangeResult % 1000);
		exType.cw = exType.won - jpy * EX_RATE_JPY; //��ȭ �Ž�����(�Ҽ�������)

		int remainToCount = jpy; //ū �������� ������ ��������
		int[] JPYunits = {10000, 5000, 2000, 1000};
		int[] JPYcount = new int[JPYunits.length]; //�� ������ ���� �������� ���� �迭

		for (int i = 0; i < JPYunits.length; i++) {
			JPYcount[i] = remainToCount / JPYunits[i];
			remainToCount = remainToCount % JPYunits[i]; //���������� ������ ������ ������ �� ����
		}
		//OutputClass���� ����ϱ����� �޼ҵ带 ���� ȯ���� ������� �־��ش�.
		outClass.printJPY(exchangeResult, jpy, JPYunits, JPYcount);
		
		//���Ͽ� ����ϱ����� ȯ���� ����� ȯ������ eur�޷��� ���
		exType.ex_result = jpy;
	}
	//�Ž����� ���
	public void returnWon(ExchangeType exType) {	
		//������ �޴� �Ž����� ���. �Ҽ��������� �Ž������� 10���� ������ 10�� ���ϸ� 1���ڸ��� ����ó�� �ȴ�. �׸��� int�� ����ȯ
		exType.returnwon = (int)(exType.cw / 10) * 10; 
		
		
		int remainToCount = exType.returnwon; //ū �������� ������ ��������
		int[] wonUnits = {10000, 5000, 1000, 500, 100, 10};
		int[] wonCount = new int[wonUnits.length]; //�� ������ ���� �������� ���� �迭

		for (int i = 0; i < wonUnits.length; i++) {
			wonCount[i] = remainToCount/wonUnits[i];
			remainToCount = remainToCount % wonUnits[i]; //���������� ������ ������ ������ �� ����
		}
		//OutputClass���� ����ϱ����� �޼ҵ带 ���� ȯ���� ������� �־��ش�.
		outClass.printWon(exType.cw, exType.returnwon, wonUnits, wonCount);
	}

}
