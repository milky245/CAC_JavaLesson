/**
 * 今月の曜日
 * 今月の日付を入力させ、その日の曜日を表示させてください。
 * 
 * 条件；
 * 　switch文で実装してください。
 * 　1～31以外の数字を入力された場合は、注意のメッセージを表示してください。
 * 
 * 実行例：
 * （正しい入力の場合）
 * 今日は5月の何日ですか＞15
 * 5月15日は金曜日です。
 * 
 * （正しくない入力の場合）
 * 今日は5月の何日ですか＞0
 * 1～31を入力してください。
 * 
 * 
 */
package section02_conditional_branch.challenge02;

public class WeekInMay {

	public static void main(String[] args) {

			int day = 0;

			System.out.print("今日は5月の何日ですか＞");
			day = new java.util.Scanner(System.in).nextInt();

			switch (day) {
				case 1:
				case 8:
				case 15:
				case 22:
				case 29:
					System.out.println("5月" + day + "日は金曜日です。");
					break;
				case 2:
				case 9:
				case 16:
				case 23:
				case 30:
					System.out.println("5月" + day + "日は土曜日です。");
					break;
				case 3:
				case 10:
				case 17:
				case 24:
				case 31:
					System.out.println("5月" + day + "日は日曜日です。");
					break;
				case 4:
				case 11:
				case 18:
				case 25:
					System.out.println("5月" + day + "日は月曜日です。");
					break;
				case 5:
				case 12:
				case 19:
				case 26:
					System.out.println("5月" + day + "日は火曜日です。");
					break;
				case 6:
				case 13:
				case 20:
				case 27:
					System.out.println("5月" + day + "日は水曜日です。");
					break;
				case 7:
				case 14:
				case 21:
				case 28:
					System.out.println("5月" + day + "日は木曜日です。");
					break;

			default :
			System.out.println("1～31を入力してください。");
			}

	}

}
