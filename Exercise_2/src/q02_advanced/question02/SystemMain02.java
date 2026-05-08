package q02_advanced.question02;
//19 SystemMain02 クラス：main メソッド内に以下の内容を記述する。
//19.1 ConsoleReader クラスオブジェクトを生成する。
//19.2 Member クラスの getInstance メソッドを呼び出して Member クラスオブジェクトを 2 つ生成し、id、password、
//name、age、rank、coupons フィールドに値を代入する。
//19.3 MemberManager クラスの showAllMembers メソッドを呼び出し、各生成オブジェクトのユーザー情報（以降、現在の
//会員情報）を出力する。
//19.4  以下、会員のパスワード変更を行うために会員情報の入力処理を行う。出力例を参考に実装すること。
//19.4.1 ConsoleReader クラスの inputNumber メソッドを呼び出し、会員 ID の入力を促す。
//19.4.2 ConsoleReader クラスの inputString メソッドを呼び出し、新しいパスワードの入力を促す。
//19.4.2.1 会員 ID、パスワード入力時の例外処理として IOException、NumberFormatException をキャッチしス
//タックトレースを出力する。その後、return 文を記述し処理を止める。
//19.5 MemberManager の updatePassword メソッドを呼び出し、現在の会員情報から入力された会員 ID と一致するユーザー
//を探し、入力された新しいパスワードに変更する。
//19.6 MemberManager クラスの showAllMembers メソッドを呼び出し、現在の会員情報を出力する。


//output example 1
/*===会員情報を表示します===
Member [id=1, password=Passw0rd, name=Miura Manabu, age=28, rank=2, coupons=[Coupon [id=1, dis
countRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特
典]]]
******************
Member [id=2, password=aaaAAA, name=Sato Kensuke, age=43, rank=1, coupons=[Coupon [id=1, disco
untRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特典]]]
******************
===パスワードを変更します===
input target id>>1
input new password>>testPass
---SHOW DATA---
Member [id=1, password=testPass, name=Miura Manabu, age=28, rank=2, coupons=[Coupon [id=1, dis
countRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特
典]]]
******************
Member [id=2, password=aaaAAA, name=Sato Kensuke, age=43, rank=1, coupons=[Coupon [id=1, disco
untRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特典]]]
******************
*output example 2
*===会員情報を表示します===
Member [id=1, password=Passw0rd, name=Miura Manabu, age=28, rank=2, coupons=[Coupon [id=1, dis
countRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特
典]]]
******************
Member [id=2, password=aaaAAA, name=Sato Kensuke, age=43, rank=1, coupons=[Coupon [id=1, disco
untRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特典]]]
******************
===パスワードを変更します===
input target id>>3
input new password>>testPass
該当者はいませんでした。
---SHOW DATA---
Member [id=1, password=Passw0rd, name=Miura Manabu, age=28, rank=2, coupons=[Coupon [id=1, dis
countRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特
典]]]
******************
Member [id=2, password=aaaAAA, name=Sato Kensuke, age=43, rank=1, coupons=[Coupon [id=1, disco
untRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特典]]]
******************
*
*output example 3
*===会員情報を表示します===
Member [id=1, password=Passw0rd, name=Miura Manabu, age=28, rank=2, coupons=[Coupon [id=1, dis
countRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特
典]]]
******************
Member [id=2, password=aaaAAA, name=Sato Kensuke, age=43, rank=1, coupons=[Coupon [id=1, disco
untRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特典]]]
******************
===パスワードを変更します===
input target id>>a
不正な入力です
java.lang.NumberFormatException: For input string: "a"
 at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
 at java.base/java.lang.Integer.parseInt(Integer.java:668)
 at java.base/java.lang.Integer.parseInt(Integer.java:786)
 at q02_advanced.question02.ConsoleReader.inputNumber(ConsoleReader.java:34)
 at q02_advanced.question02.SystemMain02.main(SystemMain02.java:66)
*/

import java.io.IOException;
import java.util.List;

public class SystemMain02 {

	public static void main(String[] args) {

		//TODO ここから実装する
		ConsoleReader cr = new ConsoleReader();
		Member member1 = Member.getInstance(1, "Passw0rd", "Miura Manabu", 28, 2);
		Member member2 = Member.getInstance(2, "aaaAAA", "Sato Kensuke", 43, 1);
		MemberManager.showAllMembers(List.of(new Member[]{member1, member2}));

		System.out.println("===パスワードを変更します===");
		int targetId = 0;
		String newPassword = null;
		try {
			System.out.print("input target id>>");
			targetId = cr.inputNumber();
			System.out.print("input new password>>");
			newPassword = cr.inputString();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return;
		}

		MemberManager.updatePassword(List.of(new Member[]{member1, member2}), targetId, newPassword);
		System.out.println("---SHOW DATA---");
		MemberManager.showAllMembers(List.of(new Member[]{member1, member2}));
	}

}
