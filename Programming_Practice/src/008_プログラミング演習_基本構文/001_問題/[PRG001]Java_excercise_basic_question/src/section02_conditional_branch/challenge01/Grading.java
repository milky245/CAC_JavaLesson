/**
 * 3科目の成績(if)
 * 
 * 整数を3個入力させ、その平均点から成績を4段階で判定するプログラムを作成してください。
 * 条件：
 * 　if文で作成してください
 * 　入力するのは整数3個
 * 　入力値は100以下でなければいけない
 * 　入力値に101以上の数字があった場合はプログラムを終了する
 * 　平均点は浮動小数で表示すること
 * 成績の判定：
 * 　平均点に応じて成績を表示する
 * 　100点なら「満点です！」
 * 　80以上100未満なら「大変良くできました。」
 * 　60以上80未満なら「よくできました。」
 * 　60未満なら「もっと頑張りましょう」
 * 
 * 補足：
 * 　プログラムを途中で終了したい場合は下記ステートメントを使います。
 * 　なお、使わなくても実装は可能です。
 * 　System.exit(0);
 * 
 * 実行例：
 * （100点満点の場合）
 * 3科目の点数を入力してください:
 * 国語＞100
 * 数学＞100
 * 英語＞100
 * 平均点は100.0点です。
 * 満点です！
 * 
 * （100より大きい数字があった場合）
 * 3科目の点数を入力してください:
 * 国語＞101
 * 数学＞88
 * 英語＞56
 * 100以下の数字を入力してください。
 * 
 */

package section02_conditional_branch.challenge01;

import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {

		int japanese = 0;
		int math = 0;
		int english = 0;
		double average = 0.0;

		Scanner sc = new Scanner(System.in);

		System.out.println("3科目の点数を入力してください:");
		System.out.print("国語＞");
		japanese = sc.nextInt();
		System.out.print("数学＞");
		math = sc.nextInt();
		System.out.print("英語＞");
		english = sc.nextInt();

		if (japanese > 100 || math > 100 || english > 100) {
			System.out.println("100以下の数字を入力してください。");
			System.exit(0);
		}
		else{
			average = (japanese + math + english) / 3.0;
			System.out.println("平均点は" + average + "点です。");

			if (average == 100) {
				System.out.println("満点です！");
			}
			else if (average >= 80) {
				System.out.println("大変良くできました。");
			}
			else if (average >= 60) {
				System.out.println("よくできました。");
			}
			else {
				System.out.println("もっと頑張りましょう");
			}
		}
		
	}

}
