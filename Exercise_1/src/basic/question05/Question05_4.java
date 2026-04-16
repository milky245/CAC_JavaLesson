package basic.question05;

import java.io.IOException;
import java.util.Scanner;

/**
 * 第8章 条件分岐
 */

public class Question05_4 {

	public static void main(String[] args) throws IOException {

		// TODO:ここに実装
		System.out.println("数学の試験結果の点数を入力してください。");
		Scanner sc = new Scanner(System.in);
		int math = sc.nextInt();

		System.out.println("国語の試験結果の点数を入力してください。");
		int japanese = sc.nextInt();

		if (math >= 60 && japanese >= 60) {
			System.out.println("数学と国語ともに合格です。");
		} else if (math>= 60 || japanese >= 60) {
			System.out.println("数学、国語のどちらかが合格です。");
		} else {
			System.out.println("どちらの教科も不合格です。");
		}

	}
}
