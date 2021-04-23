package Exchange;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWriteClass {
	/*
	 * 210422
	 * 환전의 결과들을 파일에 기록하는 클래스
	 * @kopo37(정현정)
	 */
	private FileWriter fw;
	private boolean isFileExist;

	public FileWriteClass() {//생성자
		try {
			File file = new File("C:\\Users\\정현정\\Documents\\과제\\김유두교수님\\exchangeOutput.csv");
			//파일에 대한 유무를 확인
			if(file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			//file에 FileWriter를 이용, true이면 이어쓰기, false이면 덮어쓰기
			fw = new FileWriter(file, true);	
		} catch (IOException e){
			e.printStackTrace();
		}				
	}
	//파일이 없다면 헤더를 파일에 입력한다.
	public void headerWrite() throws IOException {
		if (isFileExist == false) {
			String head = "날짜," + "환전대상," + "금액," + "환전결과," + "거스름돈" + "\n";
			fw.write(head);
		} 
	}
	//환전의 결과를 파일에 입력한다.
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
