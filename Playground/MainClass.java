package Playground;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputClass output = new OutputClass();
		PlaygroundTypeClass pgType = new PlaygroundTypeClass();
		InputFromConsoleClass input = new InputFromConsoleClass();
		
		//Ƽ��Ÿ�� ���� ���� ���
		output.printTicketType();
		
		input.selectTicekType(pgType);
		
	}

}
