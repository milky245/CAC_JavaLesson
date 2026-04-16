package advanced.question07;

import java.io.IOException;
import java.util.Scanner;

//商品価格の計算機能
//購入商品の個数をそれぞれ入力し、各商品の小計、及び全体の合計金額を表示する機能を実装する。

public class Question07_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 登録済み商品（値は変更可）
		String[] itemNames = { "ノート", "ボールペン", "消しゴム", "はさみ", "のり" };
		// 単価（値は変更可）
		int[] prices = { 100, 200, 300, 400, 500 };

		// TODO: 実装ここから
		Scanner sc = new Scanner(System.in);
		int amounts[] = new int[itemNames.length];
		int subTotals[] = new int[itemNames.length];
		int total = 0;

		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + "の購入数:>");
			amounts[i] = sc.nextInt();
			subTotals[i] = amounts[i] * prices[i];
			total+=subTotals[i];
		}
		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + "の小計: " + subTotals[i] + "円");
		}
		System.out.println("合計金額: " + total + "円");
		sc.close();
	}
}
