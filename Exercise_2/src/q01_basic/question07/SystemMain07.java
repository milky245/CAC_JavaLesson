package q01_basic.question07;

/*
6 SystemMain07 クラス：main メソッド内に以下の内容を記述する。
6.1 ConsoleReader クラスオブジェクトを生成する。
6.2 以下、任意の整数の入力処理を行う。出力例を参考に実装すること。
6.2.1 ConsoleReader クラスの inputNumber メソッドを呼び出し、整数の入力を促す。
6.2.2 整数入力時の例外処理としてスタックトレースを出力する。
6.3 NumberList クラスの addFromOneTo メソッドを呼び出し、入力された整数を基に numbers フィールドに値を代入す
る。
6.4 NumberList クラスの getNumbers メソッドを呼び出し numbers フィールドの値を取得する。取得した numbers を出力
する。なお println(numbers);のように List オブジェクトを println の引数にすことで出力する。
6.5 NumberList クラスの calcSumOfList メソッドを呼び出し、numbers フィールドの各要素の合計値を取得し、出力する。
出力例を参考に実装すること。
6.6 NumberList クラスの doubleListEachValue メソッドを呼び出し、numbers フィールドの各要素を 2 倍にする。
6.7 ２倍になった numbers フィールドの値を出力する。出力例を参考に実装すること。
6.8 NumberList クラスの removeIndexOfFirstHalf メソッドを呼び出し、numbers フィールドの要素の前半部分を削除す
る。
6.9 前半分が削除された numbers フィールドの値を出力する。出力例を参考に実装すること。


* 出力例1
1-任意の整数をList に代入します
input number>>20
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
****************
List の合計を計算します
1 から20 までの合計は210です。
****************
List の各要素を2 倍します
[2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40]
****************
List の前半分のインデックスの要素を削除します
[22, 24, 26, 28, 30, 32, 34, 36, 38, 40]
 出力例2（異常系）
1-任意の整数をList に代入します
input number>>a
java.lang.NumberFormatException: For input string: "a"
 at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
 at java.base/java.lang.Integer.parseInt(Integer.java:668)
 at java.base/java.lang.Integer.parseInt(Integer.java:786)
 at q01_basic.question07.ConsoleReader.inputNumber(ConsoleReader.java:34)
 at q01_basic.question07.SystemMain07.main(SystemMain07.java:38)
[]
****************
List の合計を計算します
1 から0 までの合計は0 です。
****************
List の各要素を2 倍します
[]
****************
List の前半分のインデックスの要素を削除します
[]
* **/

public class SystemMain07 {

	public static void main(String[] args) {

		NumberList numberList = new NumberList();
		System.out.println("1-任意の整数をListに代入します");
		System.out.print("input number>>");
		int limit = 0;
		//TODO ここから実装する
		ConsoleReader cr = new ConsoleReader();
		try {
			limit = cr.inputNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		numberList.addFromOneTo(limit);
		System.out.println(numberList.getNumbers());

		System.out.println("****************");
		System.out.println("Listの合計を計算します");
		int sum = 0;
		//TODO ここから実装する

		sum = numberList.calcSumOfList();

		System.out.println("1から" + limit + "までの合計は" + sum + "です。");

		System.out.println("****************");
		System.out.println("Listの各要素を2倍します");
		//TODO ここから実装する
		numberList.doubleListEachValue();
		System.out.println(numberList.getNumbers());

		System.out.println("****************");
		System.out.println("Listの前半分のインデックスの要素を削除します");
		//TODO ここから実装する
		numberList.removeIndexOfFirstHalf();
		System.out.println(numberList.getNumbers());

	}

}
