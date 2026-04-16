package basic.question06;

import java.io.IOException;
import java.util.Scanner;

public class Question06_3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// TODO:ここに実装
		int amount = 0;
		int price = 100;
		System.out.printf("鉛筆を購入しますか？\nはい：0、いいえ：1＞");
		Scanner sc = new Scanner(System.in);
		int buyFlag = sc.nextInt();
		while(buyFlag == 0) {
			amount++;
			System.out.printf("鉛筆を購入しますか？\nはい：0、いいえ：1＞");
			buyFlag = sc.nextInt();
		}
		System.out.println("購入した鉛筆の本数は" + amount + "本です。");
		System.out.println("合計金額は" + (price * amount) + "円です。");
		sc.close();
	}

}
