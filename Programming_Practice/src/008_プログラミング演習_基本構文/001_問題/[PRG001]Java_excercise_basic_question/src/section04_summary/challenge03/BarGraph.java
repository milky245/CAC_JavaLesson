/**
 * 横棒グラフの表示
 * 
 * 実行例.txtを参考に棒グラフを表示してください。
 * 配列の要素数を入力させ、その数だけ縦棒グラフを表示してください。
 * 棒グラフは*で表し、数は1～10個でランダムとします。
 * 一番左にはインデックスの下1桁を表示してください。
 * BarGraf.java
 * 要素数＞12
 * 0:****
 * 1:******
 * 2:*********
 * 3:**********
 * 4:**
 * 5:*
 * 6:****
 * 7:*****
 * 8:***
 * 9:********
 * 0:***
 * 1:*******
 */
package section04_summary.challenge03;

import java.util.Random;
import java.util.Scanner;

public class BarGraph {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("要素数＞");
		int size = scanner.nextInt();
		int[] array = new int[size];
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10) + 1; // 1～10までの値をランダムに1つ代入する
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(i % 10 + ":");
			for (int j = 0; j < array[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		scanner.close();

	}

}
