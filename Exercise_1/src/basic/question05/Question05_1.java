package basic.question05;

import java.io.IOException;
import java.util.Scanner;

/**
 * 第8章 条件分岐
 */

public class Question05_1 {

	public static void main(String[] args) throws IOException {

		// TODO:ここに実装
		System.out.println("年齢を入力してください。");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 20) {
			System.out.println("20歳未満なので、お酒の提供ができません。");
		} else {
			System.out.println("20歳以上なので、お酒の提供することが可能です。");
		}
		sc.close();

	}
}
