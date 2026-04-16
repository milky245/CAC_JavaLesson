package basic.question02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 第5章 入出力
 */

public class Question02_2 {

	public static void main(String[] args) throws IOException {

		// TODO:ここに実装
		System.out.println("商品の名前と値段を入力してください。");
		Scanner scanner = new Scanner(System.in);
		String itemName = scanner.nextLine();
		int itemPrice = scanner.nextInt();
		System.out.printf("商品の名前は%sです。\n商品の値段は%d\n", itemName, itemPrice);
		//scanner.close();

		//here we use bufferedreader and inParse do this again
		System.out.println("商品の名前と値段を入力してください。");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String itemName2 = reader.readLine();
		int itemPrice2 = Integer.parseInt(reader.readLine());
		System.out.printf("商品の名前は%sです。\n商品の値段は%d\n", itemName2, itemPrice2);
		//reader.close();


	}
}
