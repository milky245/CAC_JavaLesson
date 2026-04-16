package basic.question02;

import java.io.IOException;
import java.util.Scanner;

/**
 * 第5章 入出力
 */

public class Question02_1 {

	public static void main(String[] args) throws IOException {

		// TODO:ここに実装
		System.out.println("名前を入力してください。");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("好きなスポーツを入力してください。");
		String sport = scanner.nextLine();
		System.out.printf("私の名前は%sです。\n好きなスポーツは%sです。\n", name, sport);
		scanner.close();

	}
}
