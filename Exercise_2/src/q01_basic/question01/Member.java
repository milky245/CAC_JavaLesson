package q01_basic.question01;
/**
 * 会員クラス
 * 会員の名前、年齢、ランクをフィールドとして持ち、会員の情報を表示するメソッドを持つ。
 */

class Member {
	//TODO ここから実装する
    String name; // 会員の名前
    int age; // 会員の年齢
    int rank; // 会員のランク


    /**
     * 会員の情報を表示するメソッド
     */
    public void showMember() {
        System.out.println("***MEMBER DATA***");
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        System.out.println("rank:" + rank);
        System.out.println("*****************");
    }

}
