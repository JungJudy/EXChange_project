package Exchange;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWriteClass {
	/*
	 * 210422
	 * ȯ���� ������� ���Ͽ� ����ϴ� Ŭ����
	 * @kopo37(������)
	 */
	private FileWriter fw;
	private boolean isFileExist;

	public FileWriteClass() {//������
		try {
			File file = new File("C:\\Users\\������\\Documents\\����\\�����α�����\\exchangeOutput.csv");
			//���Ͽ� ���� ������ Ȯ��
			if(file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			//file�� FileWriter�� �̿�, true�̸� �̾��, false�̸� �����
			fw = new FileWriter(file, true);	
		} catch (IOException e){
			e.printStackTrace();
		}				
	}
	//������ ���ٸ� ����� ���Ͽ� �Է��Ѵ�.
	public void headerWrite() throws IOException {
		if (isFileExist == false) {
			String head = "��¥," + "ȯ�����," + "�ݾ�," + "ȯ�����," + "�Ž�����" + "\n";
			fw.write(head);
		} 
	}
	//ȯ���� ����� ���Ͽ� �Է��Ѵ�.
	public void dataWrite(ExchangeType exType) throws IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String result = (sdf.format(calendar.getTime()) + "," + exType.typeStr + "," + exType.won + "," + exType.ex_result + "," + exType.returnwon + "\n");
		fw.write(result);
	}
	public void fileClose() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
