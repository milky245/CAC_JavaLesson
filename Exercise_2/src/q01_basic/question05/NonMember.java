package q01_basic.question05;
/**
 * 非会員クラス
 * 名前をフィールドとして持ち、非会員の情報を表示するメソッドを持つ。
 * AbstMember クラスを継承する。
 */
public class NonMember extends AbstMember {
    //TODO ここから実装する
    public NonMember(String name) {
        this.name = name;
    }

    /**
     * 商品を購入した際の処理を記述する。
     */
    public void buyItem() {
        //System.out.println(name + "さんが商品を購入しました。");
        System.out.println(name + " purchased the item at a fixed price");
    }

        /**
        * 非会員の情報を表示する。
        */
    public void showMember() {
        System.out.println("***NON-MEMBER DATA***");
        System.out.println(name + "is a non-member");
        System.out.println("*********************");
    }
}
