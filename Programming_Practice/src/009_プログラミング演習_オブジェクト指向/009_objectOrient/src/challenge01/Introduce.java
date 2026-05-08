//1,Humanクラスを定義します
//	Humanクラスは最低でも以下のフィールド、メソッドを持ちます
//	・名前
//	・性別
//	・年齢
//	・誕生日（Dayクラスを使うこと（Day.java））
//	・自己紹介（toString()メソッドを実装）
//	・コンストラクタ（引数なし、名前のみ、名前＋性別＋年齢＋誕生日）
//	これ以外に必要なものがあれば適宜追加すること
//2,Humanクラスを実行するIntroduceクラス(mainメソッド)を定義します
//	Introduceクラスは対話形式でHumanクラスをインスタンス化すること
//	最終的に自己紹介をコンソールに出力すること
package challenge01;

public class Introduce {
    public static void main(String[] args) {
        Human human1 = new Human();
        System.out.println("=== デフォルトの人 ===");
        System.out.println(human1);

        Human human2 = new Human("山田太郎");
        System.out.println("\n=== 名前だけ指定した人 ===");
        System.out.println(human2);

        Day birthday = new Day(1990, 5, 15);
        Human human3 = new Human("佐藤花子", "女性", 30, birthday);
        System.out.println("\n=== 全ての情報を指定した人 ===");
        System.out.println(human3);
    }

}
