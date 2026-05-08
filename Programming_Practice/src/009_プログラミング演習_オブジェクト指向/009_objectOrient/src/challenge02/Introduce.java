package challenge02;

import java.util.Scanner;

/**
 * 自己紹介出力プログラム
 * @author k-mori
 *
 */
public class Introduce {
	/**
	 * mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		// Humanのフィールドに代入する値を入力
		System.out.print("あなたの名前は："); String name = stdIn.nextLine();
		System.out.print("あなたの性別は："); String gender = stdIn.nextLine();
		System.out.print("あなたの年齢は："); int age = stdIn.nextInt();
		System.out.print("あなたの誕生日の年は："); int year = stdIn.nextInt();
		System.out.print("あなたの誕生日の月は："); int mounth = stdIn.nextInt();
		System.out.print("あなたの誕生日の日は："); int day = stdIn.nextInt();
		System.out.println("あなたの部署番号は："); int departNumber = stdIn.nextInt();

		// Humanクラスのmeを宣言、Humanクラスをインスタンス化する
		Human me = new Human(name, gender, age, new Day(year, mounth, day), departNumber);

		// 自己紹介の出力
		System.out.println("改めて自己紹介します。");
		System.out.println(me);

	}

}
