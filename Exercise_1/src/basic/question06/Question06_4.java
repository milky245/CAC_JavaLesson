package basic.question06;

import java.io.IOException;
import java.util.Scanner;

public class Question06_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// TODO:ここに実装
		int amountBooks = 0;
		int sellFlag = 0;
		int bookPrice = 200;
		System.out.println("本を売却します。");
		Scanner sc = new Scanner(System.in);
		do {
			amountBooks++;
			System.out.printf("売却する本の冊数を1つ増やしますか？\nはい：0、いいえ：1＞");
			sellFlag = sc.nextInt();
		}while (sellFlag == 0);

		System.out.println("売却する本の冊数は" + amountBooks + "冊です。");
		System.out.println("合計金額は" + (bookPrice * amountBooks) + "円です。");
		sc.close();

	}

}
