/**
 * クラスの成績 (多次元配列）
 *
 * 実行例を参考に、クラス毎の成績を計算して一覧を出力してください
 * クラス数は2、1クラスあたりの生徒数は3人の2次元配列で定義してください。
 * クラスの各生徒に、整数の点数を入力し、クラスごとの成績を出力します。
 * 成績は、クラスごとの合計点と平均点(少数まで)を出力します。
 *
 * (実行例)
 * 1組、出席番号1番の点数＞5
 * 1組、出席番号2番の点数＞7
 * 1組、出席番号3番の点数＞9
 * 2組、出席番号1番の点数＞11
 * 2組、出席番号1番の点数＞13
 * 2組、出席番号1番の点数＞17
 * 1組の合計点は21点、平均点は7.0点です。
 * 2組の合計点は41点、平均点は13.666666666666666点です。
 *
 */

package section01_array.challenge03;

import java.util.Scanner;

public class GradeList_Array {

	public static void main(String[] args) {
		// 標準入力の準備
		Scanner stdIn = new Scanner(System.in);
		int[][] allStudents = new int[2][3];

		// 成績の入力
		for (int clsIndex = 0; clsIndex < allStudents.length; clsIndex++) {
			for (int stuIndex = 0; stuIndex < allStudents[clsIndex].length; stuIndex++) {

				System.out.print((clsIndex + 1) + "組、出席番号" + (stuIndex + 1) + "番の点数＞");
				allStudents[clsIndex][stuIndex] = stdIn.nextInt();

			}
		}

		// 成績の出力と計算
		for (int classIndex = 0; classIndex < allStudents.length; classIndex++) {
			int sum = 0;
			for (int studentIndex = 0; studentIndex < allStudents[classIndex].length; studentIndex++) {
				sum += allStudents[classIndex][studentIndex];
			}
			double average = (double) sum / allStudents[classIndex].length;
			System.out.println((classIndex + 1) + "組の合計点は" + sum + "点、平均点は" + average + "点です。");
		}

		// 標準入力の終了
		stdIn.close();
	}

}
