package review;

import java.util.Scanner;

/* プログラムの作り方
 * 
 *  1 データの準備
 *  2 入力
 *  3 処理（if,for）
 *  4 出力
 *  で組み立てると良いです。
 *  今回はFIzzBuzzという有名な処理で紹介します
 *  
 *  ルール
 *  1から順に数を数え上げていき、3の倍数なら「Fizz」、
 *  5の倍数なら「Buzz」、両方の倍数（15の倍数）なら「Fizz Buzz」、
 *  いずれでもなければその数を言う。
 *  
 *  */
public class FizzBuzz_q {


	/*
	 * 追加①
	 * 文字列配列を準備し、for文の中で文字列、および数値を文字列に変更したものを配列に格納する。
	 * 出力は配列に格納したものを取りだしつつ「,」で区切る
	 * 
	 * 1,2,Fizz,4,Buzz,..
	 * 
	 * hint
	 * String numString =String.valueOf(i);//int -> String
	 * 
	 * 追加②
	 * 3,5ではなく標準入力した値の倍数の時にFizz、Buzz、2つの最小公倍数ではFizzBuzzと出力する
	 * 
	 * 一つ目の倍数>>4
	 * 二つ目の倍数>>7
	 * 
	 * ..,3,Fizz,5,6,Buzz,..
	 * 
	 * */
	public static void main(String[] args) {


		//1 データの準備
		String fizzString = "Fizz";
		String buzzString = "Buzz";
		String fizzbuzzString = fizzString + buzzString;
		String[] outputArray = new String[100];


		// 2 処理&出力
		calFizzBuzz(outputArray, 3, 5, fizzString, buzzString, fizzbuzzString);


		//System.out.println(String.join(",", outputArray));
		for (int i = 0; i < outputArray.length; i++) {
			System.out.print(outputArray[i]);
			if (i < outputArray.length - 1) {
				System.out.print(",");
			}
			if(i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();

		//追加②
		Scanner sc = new Scanner(System.in);
		System.out.println("一つ目の倍数>>");
		int firstMultiple = sc.nextInt();
		System.out.println("二つ目の倍数>>");
		int secondMultiple = sc.nextInt();

		//use method
		calFizzBuzz(outputArray, firstMultiple, secondMultiple, fizzString, buzzString, fizzbuzzString);

		System.out.println("\nカスタム倍数のFizzBuzz:");
		for (int i = 0; i < outputArray.length; i++) {
			System.out.print(outputArray[i]);
			if (i < outputArray.length - 1) {
				System.out.print(",");
			}
			if(i % 10 == 0) {
				System.out.println();
			}
		}
	}

	//make it as method
	public static String[] calFizzBuzz(String[] outputArray, int firstMultiple, int secondMultiple,
									   String str1, String str2, String str3)

	{
		for (int i = 0; i < outputArray.length; i++) {
			if (i % firstMultiple == 0 && i % secondMultiple == 0) {
				outputArray[i] = str3;
			}
			else if (i % firstMultiple == 0) {
				outputArray[i] = str1;
			}
			else if (i % secondMultiple == 0) {
				outputArray[i] = str3;
			}
			else {
				outputArray[i] = String.valueOf(i);
			}
		}

		return outputArray;
	}

}
