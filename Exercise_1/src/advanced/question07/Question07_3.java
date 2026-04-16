package advanced.question07;

import java.io.IOException;
import java.util.Scanner;

//購入商品の在庫チェック機能
//商品購入時、在庫数の超過をチェックする機能を実装する。
public class Question07_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 登録済み商品（値は変更可）
		String[] itemNames = { "ノート", "ボールペン", "消しゴム", "はさみ", "のり" };
		// 単価（値は変更可）
		int[] prices = { 100, 200, 300, 400, 500 };
		// 購入数（変更不可）
		int[] amounts = new int[5];
		int totalPrice = 0;
		Scanner sc = new Scanner(System.in);

		// TODO: 実装ここから
		int[] stocks = new int[itemNames.length];
		for (int i = 0; i < stocks.length; i++) {
			System.out.println(itemNames[i] + "の在庫数:>");
			stocks[i] = sc.nextInt();
		}
		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + "の購入数:>");
			amounts[i] = sc.nextInt();
			if (amounts[i] > stocks[i]) {
				System.out.println("在庫を超えています。もう一度入力してください。");
				i--;
			}
			else {
				System.out.println("在庫　"+stocks[i]);
				stocks[i] -= amounts[i];
				System.out.println("残りの在庫　"+stocks[i]);
				totalPrice += prices[i] * amounts[i];
			}
		}
		System.out.println("合計金額: " + totalPrice);

	}
}
