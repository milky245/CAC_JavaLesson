package advanced.question07;

import java.io.IOException;
import java.util.Scanner;

//購入明細一覧の表示
//最後に購入内容を一覧表示して、お客様に渡せる機能
public class Question07_5 {

	public static void main(String[] args) throws IOException {

		// 登録商品（値は変更可）
		String[] itemNames = { "ノート", "ボールペン", "消しゴム", "はさみ", "のり" };
		// 単価（値は変更可）
		int[] prices = { 120, 80, 50, 250, 100 };
		// 購入数（変更不可）
		int[] amounts = new int[5];

		// TODO: 実装ここから
		int[] taxIncludedPrices = new int[itemNames.length];
		//calculating tax included price for each item
		for (int i = 0; i < itemNames.length; i++) {
			taxIncludedPrices[i] = (int) (prices[i] * 1.1);
		}

		int totalPrice = 0;
		int finalTotalPrice = 0;
		int[] subtotals = new int[itemNames.length];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + "の購入数:>");
			amounts[i] = sc.nextInt();
		}
		//商品名：単価〇円（税込〇円）× 〇個 = 〇円
		// 購入する商品の購入情報を1行を表示
		System.out.println("購入内容一覧:");
		for (int i = 0; i < itemNames.length; i++) {
			subtotals[i] = taxIncludedPrices[i] * amounts[i];
			totalPrice += subtotals[i];
			System.out.println(itemNames[i] +
					"：単価 " + prices[i] +
					"円（税込 " + taxIncludedPrices[i] +
					"円）× " + amounts[i] +
					"個 = " + subtotals[i] + "円");
		}
		System.out.println("合計金額（税込）: " + totalPrice + "円");
		finalTotalPrice = (int) (totalPrice * 0.9);
		System.out.println("割引後合計（税込）: " + finalTotalPrice + "円");


	}
}