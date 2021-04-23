package Exchange;

public class ExchangeType {
	double won; //입력받은 원화
	int type; //입력받는 환전타입
	double cw; //원화 거스름돈(소수점까지)
	int returnwon; //실제 원화 거스름돈
	String typeStr;  //환전타입의 문자열
	double ex_result; //환전결과(파일에 기록용)
}
