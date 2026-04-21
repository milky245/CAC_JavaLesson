/**
 * 素数判定
 * 特定の数字１個の判定
 *
 * 1と自分自身以外に正の約数を持たない自然数のことを素数と言います。
 * 言い換えると、2以上n未満の約数を持たない自然数nを素数といいます。
 * ※ちなみに、自然数nを割り切れる自然数xはn/2以下の数字です。
 *
 * 入力した整数が素数であることを判定するプログラムを作成してください。
 *
 * 実行例：
 * （素数である場合）
 * 整数を入力してください＞2749
 * 2749は素数です
 *
 * （素数でない場合）
 * 整数を入力してください＞100
 * 100は素数ではありません。
 *
 * ====
 * ScannerクラスはBufferedReaderクラスの仲間で、標準入力するための機能を持ちます。
 * 文字列を入力する場合は「String target = stdIn.next();」のように使います。
 * 整数を入力する場合は「int target = stdIn.nextInt();」のように使います。
 * BRと違って、文字と数値の変換が不要です。
 */

package section03_repetition.challenge01;

import java.util.Scanner;

public class PrimeNumber_level1 {
	public static boolean isPrime(int n){
		if (n <= 1) return false; // 1以下は素数ではない
		if (n <= 3) return true; // 2と3は素数
		if (n % 2 == 0 || n % 3 == 0) return false; // 2または3の倍数は素数ではない

		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) return false; // 6k ± 1の形の数で割り切れるかチェック
		}
		return true; // 素数である
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("整数を入力してください＞");
		int target = stdIn.nextInt();
		if (isPrime(target)) {
			System.out.println(target + "は素数です");
		} else {
			System.out.println(target + "は素数ではありません。");
		}
	}

}
