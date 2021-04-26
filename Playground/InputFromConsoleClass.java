package Playground;

import java.util.Scanner;

public class InputFromConsoleClass {
	Scanner scanner;
	
	InputFromConsoleClass() {
		scanner = new Scanner(System.in);
	}
	public void selectTicekType(PlaygroundTypeClass pgType) {
		while(true) {
			pgType.ticketType = scanner.nextInt();
			if (pgType.ticketType >= ConstValueClass.DAY_PRICE_TYPE && pgType.ticketType <= ConstValueClass.NIGHT_PRICE_TYPE) {
				break;
			} else {
				System.out.println("주관권과 야간권만 선택 할 수 있습니다. 다시 입력해주세요.");
			}
		}
		
		if (pgType.ticketType == ConstValueClass.DAY_PRICE_TYPE) {
			pgType.ticktTypeStr = "주간권";
		} else if (pgType.ticketType == ConstValueClass.NIGHT_PRICE_TYPE) {
			pgType.ticktTypeStr = "야간권";
		}
	}
}
