package q02_advanced.question02;

/**
 * 会員クラス
 * 会員のID、パスワード、名前、年齢、ランクをフィールドとして持ち、会員の情報を表示するメソッドを持つ。
 * クーポンのリストもフィールドとして持ち、クーポンの情報も表示する。
 */
import java.util.ArrayList;
import java.util.List;

class Member {
    //TODO ここから実装する
    private int id; // 会員ID
    private String password; // パスワード
    private String name; // 会員の名前private
    private int age; // 会員の年齢
    private int rank; // 会員のランク

    private List<Coupon> coupons; // クーポンのリスト

    /**
     * 引数なしのコンストラクタを定義する。フィールドは適切な初期値を代入する。
     */
    public Member() {
        this.password = null;
        this.name = null;
        this.age = 0;
        this.rank = 0;
    }

    /**
     * 引数ありのコンストラクタを定義する。引数で取得した値をフィールドに代入する。
     */
    public Member(int id, String password, String name, int age, int rank) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.coupons = new ArrayList<>();
    }

//    public void buyItem() {
//        //System.out.println(name + "さんが商品を購入しました。");
//        System.out.println(name + " purchased the item at 50% off");
//    }

    /**
     * getInstance メソッドを定義する。引数で取得した id、password、name、age を使用して Member クラスオブジェクトを生成し、戻り値として返す。
     * @param id
     * @param password
     * @param name
     * @param age
     * @param rank
     * @return
     */
    public static Member getInstance(int id, String password, String name, int age, int rank) {
        Member member = new Member(id, password, name, age, rank);
        Coupon coupon1 = Coupon.getInstance(1, 0.5, "最初の特典");
        Coupon coupon2 = Coupon.getInstance(2, 0.25, "今月の特典");

        member.setCoupons(List.of(coupon1, coupon2));
        return member;
    }

    /**
     * toString メソッドをオーバーライドする。会員の情報を文字列として返す。
     */
    @Override
    public String toString() {
        return "Member[" +
                "id=" + id +
                ", password='" + password +
                ", name='" + name +
                ", age=" + age +
                ", rank=" + rank +
                ", coupons=" + coupons +
                ']';
    }

    /**
     * showMember メソッドを定義する。会員の情報を表示する。
     */
    public void showMember() {
        //System.out.println("***MEMBER DATA***");
        System.out.println(toString());
        System.out.println("*****************");
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    // クーポンのゲッターとセッター
    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

}
