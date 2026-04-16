package advanced.question07;

import java.io.IOException;
import java.util.Scanner;

//割引と税込処理
//購入商品の合計金額に基づき、割引を行う機能を実装する。

public class Question07_4 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 登録済み商品（値は変更可）
		String[] itemNames = { "ノート", "ボールペン", "消しゴム", "はさみ", "のり" };
		// 単価（値は変更可）
		int[] prices = { 100, 200, 300, 400, 500 };
		// 購入数（変更不可）
		int[] amounts = new int[5];

		// TODO: 実装ここから
		//合計金額5000円以上で10%割引、それ以外の場合は割引なし
		//10%の税率を各商品の小計に加算して、合計金額（税込）を表示
		int totalPrice = 0;
		int[] subtotals = new int[itemNames.length];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + "の購入数:>");
			amounts[i] = sc.nextInt();
			subtotals[i] = prices[i] * amounts[i];
			totalPrice += subtotals[i];
		}
		//int originalTotalPrice = totalPrice;
		if (totalPrice >= 5000) {
			System.out.println("割引前合計：" + totalPrice);
			totalPrice = (int) (totalPrice * 0.9);
			System.out.println("割引適用（10%OFF）：" + totalPrice);
		}
		else{
			System.out.println("割引なし。合計金額：" + totalPrice);
		}
		int taxIncludedPrice = (int) (totalPrice * 1.1);
		System.out.println("税込合計：" + taxIncludedPrice);

	}

}
