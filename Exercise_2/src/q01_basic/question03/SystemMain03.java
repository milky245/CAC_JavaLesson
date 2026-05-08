/*
* ---SHOW DATA(NULL)---
***MEMBER DATA***
name:null
age:0
rank:0
*****************
---SHOW DATA(Miura)---
***MEMBER DATA***
name:Miura Manabu
age:28
rank:2
******************/
package q01_basic.question03;

public class SystemMain03 {

	public static void main(String[] args) {
		//TODO ここから実装する
		// 会員のインスタンスを作成
		Member member1 = new Member(); // デフォルトコンストラクタを使用
		Member member2 = new Member("Miura Manabu", 28, 2); // 引数付きコンストラクタを使用

		// 会員の情報を表示
		System.out.println("---SHOW DATA(NULL)---");
		member1.showMember();

		System.out.println("---SHOW DATA(Miura)---");
		member2.showMember();

	}

}
