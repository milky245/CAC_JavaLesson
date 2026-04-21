/**
 * 一年の経過と残り
 * 入力した日付から、一年の経過日数と残り日数を計算して出力してください。
 * 2月は28日とします。
 * 
 * 不正な月や日を入力された場合はプログラムを終了してください。
 * 下記ステートメントを実行するとプログラムが終了します。
 * System.exit(0);
 * 
 * 実行例：
 * （正しい日付を入力）
 * 今は何月ですか＞5
 * 今日は何日ですか＞15
 * 一年の経過日数は135日です。
 * 一年の残り日数は230日です。
 * 
 * （不正な月を入力）
 * 今は何月ですか＞13
 * 1～12を入力してください
 * 
 * （不正な日付を入力）
 * 今は何月ですか＞2
 * 今日は何日ですか＞29
 * 正しい日付を入力してください
 * 
 * ヒント：
 * ・if文とswitch文を組み合わせて実装することを想定しています。
 * ・月や日は決まっている数字なので「定数」です。
 * ・処理をいくつかのセクションに区切って考えるとよいでしょう。
 * 　以下のようなセクション分けが考えられます。
 * 　・月の入力と、入力値の確認
 * 　・日の入力と、入力値の確認
 * 　・経過日数の計算
 * 　・残日数の計算
 * 　・結果の出力
 * 
 */

package section02_conditional_branch.challenge03;

import java.util.Scanner;

public class ElapsedAndRemainingDays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month, day;
		int elapsedDays = 0;
		int remainingDays = 0;

		System.out.print("今は何月ですか＞");
		month = sc.nextInt();
		if (month < 1 || month > 12) {
			System.out.println("1～12を入力してください");
			System.exit(0);
		}
		System.out.print("今日は何日ですか＞");
		day = sc.nextInt();
		if (day < 1 || day > 31) {
			System.out.println("1～31を入力してください");
			System.exit(0);
		}
		//if文とswitch文を組み合わせて実装することを想定しています。
		// * ・月や日は決まっている数字なので「定数」です。
		// * ・処理をいくつかのセクションに区切って考えるとよいでしょう。
		// * 　以下のようなセクション分けが考えられます。


		if (month<3){
			switch (month) {
				case 1:
					elapsedDays = day;
					remainingDays = 365 - elapsedDays;
					break;
				case 2:
					if (day > 28) {
						System.out.println("正しい日付を入力してください");
						System.exit(0);
					}
					elapsedDays = 31 + day;
					remainingDays = 365 - elapsedDays;
					break;
			}
		}else{
			elapsedDays=59; // 1月と2月の合計日数
			// 3月以降は、月ごとの日数を加算していく
			for (int m = 3; m < month; m++) {
				switch (m) {
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						elapsedDays += 31;
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						elapsedDays += 30;
						break;
				}
			}
		}


		elapsedDays += day;
		remainingDays = 365 - elapsedDays;
		System.out.println("一年の経過日数は" + elapsedDays + "日です。");
		System.out.println("一年の残り日数は" + remainingDays + "日です。");
		sc.close();

	}

}