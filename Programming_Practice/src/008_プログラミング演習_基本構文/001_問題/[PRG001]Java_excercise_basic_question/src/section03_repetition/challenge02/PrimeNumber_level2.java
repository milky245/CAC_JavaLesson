/**
 * 素数判定
 * 範囲内の数字の素数判定
 * 
 * 1と自分自身以外に正の約数を持たない自然数のことを素数と言います。
 * 言い換えると、2以上n未満の約数を持たない自然数nを素数といいます。
 * ※ちなみに、自然数nを割り切れる自然数xはn/2以下の数字です。
 * 
 * 2～入力した整数までの数字の中で、素数である数字を抽出する
 * プログラムを作成してください。
 * 
 * 実行例：
 * 整数を入力してください＞20
 * 20までの素数は以下の数字です。
 * 2, 3, 5, 7, 11, 13, 17, 19, 
 * 
 */

package section03_repetition.challenge02;

import java.util.Scanner;

public class PrimeNumber_level2 {
	public static boolean isPrime(int n){
		if (n <= 1) return false; // 1以下は素数ではない
		if (n <= 3) return true; // 2と3は素数
		if (n % 2 == 0 || n % 3 == 0) return false; // 2または3の倍数は素数ではない

		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) return false; // 6k ± 1の形の数で割り切れるかチェック
		}
		return true; // 素数である
	}

	public static void printPrimesUpTo(int n) {
		System.out.println(n + "までの素数は以下の数字です。");
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.print(i + ", ");
			}
		}
		System.out.println(); // 最後に改行を入れる
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("整数を入力してください＞");
		int target = stdIn.nextInt();
		printPrimesUpTo(target);
	}

}
