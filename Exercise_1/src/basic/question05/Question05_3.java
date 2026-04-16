package basic.question05;

import java.io.IOException;
import java.util.Scanner;

/**
 * 第8章 条件分岐
 */

public class Question05_3 {

	public static void main(String[] args) throws IOException {

		// TODO:ここに実装
		System.out.println("曜日を入力してください。");
		Scanner sc = new Scanner(System.in);
		String userDayInput = sc.nextLine();
		switch (userDayInput) {
		case "月曜日":
			System.out.println("Monday");
			break;
		case "火曜日":
			System.out.println("Tuesday");
			break;
		case "水曜日":
			System.out.println("Wednesday");
			break;
		case "木曜日":
			System.out.println("Thursday");
			break;
		case "金曜日":
			System.out.println("Friday");
			break;
		case "土曜日":
			System.out.println("Saturday");
			break;
		case "日曜日":
			System.out.println("Sunday");
			break;
		default:
			System.out.println("無効な入力です。");
		}
		sc.close();

	}
}
