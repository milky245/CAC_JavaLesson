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

public class Human {
    private String name; // 名前
    private String gender;
    private int age; // 年齢
    private Day birthday; // 誕生日

    @Override
    public String toString() {
        return "私の名前は" + name + "です。性別は " + gender + "です。年齢は" + age + "歳です。誕生日は " + birthday.getYear() + "年" + birthday.getMonth() + "月" + birthday.getDate() + "日です。";
    }

    public Human() {
        this.name = "名前なし";
        this.gender = "性別不明";
        this.age = 0;
        this.birthday = new Day();
    }

    public Human(String name) {
        this.name = name;
        this.gender = "性別不明";
        this.age = 0;
        this.birthday = new Day();
    }

    public Human(String name, String gender, int age, Day birthday) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = new Day(birthday);
    }// Dayクラスのコピーコンストラク

    // getterとsetter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Day getBirthday() {
        return birthday;
    }

    public void setBirthday(Day birthday) {
        this.birthday = birthday;
    }
}
