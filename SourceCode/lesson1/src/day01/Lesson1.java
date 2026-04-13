//問題
//パッケージ名 day1
//クラス名 Lesson1.java

//"出力します"とコンソールに出力してください。
//続けて12、 1.6、 "こんにちは"、 'a'をそれぞれ変数に代入しコンソールに出力してください。
//また1行コメントで記入しなさい。（コメント例 〇〇を出力する）

//【出力例】
//出力します
//12
//1.6
//こんにちは
//a

package day01;

public class Lesson1 {

	public static void main(String[] args) {
		//ここから記述
		System.out.println("出力します");
		System.out.println(12);
		System.out.println(1.6);
		System.out.println("こんにちは");
		System.out.println("a");
		//Lesson1 のテキストを出力する

		int num1 = 12;
		double d1 = 1.6;
		String str1 = "こんにちは";
		char ch1 = 'a';
		System.out.printf("%d%n%.1f%n%s%n%c%n", num1, d1, str1, ch1);
		//Another way to output

        float f1 = 1.62f;
        //be careful with float, you need to add 'f' at the end of the number to indicate it's a float, otherwise it will be treated as a double by default
        System.out.printf("%.2f%n", f1);
	}

}
