package q02_advanced.question01;
/**
 * 会員クラス
 * 会員のID、パスワード、名前、年齢、ランクをフィールドとして持ち、会員の情報を表示するメソッドを持つ。
 * クーポンのリストもフィールドとして持ち、クーポンの情報も表示する。
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 会員クラス
 * 会員のID、パスワード、名前、年齢、ランクをフィールドとして持ち、会員の情報を表示するメソッドを持つ。
 * クーポンのリストもフィールドとして持ち、クーポンの情報も表示する。
 */
class Member {
    //TODO ここから実装する
    private int id; // 会員ID
    private String password; // パスワード
    private String name; // 会員の名前private
    private int age; // 会員の年齢
    private int rank; // 会員のランク

    private List<Coupon> coupons; // クーポンのリスト

    public Member() {
        this.password = null;
        this.name = null;
        this.age = 0;
        this.rank = 0;
    }

    public Member(int id, String password, String name, int age, int rank) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.rank = rank;
        Coupon coupon1 = Coupon.getInstance(1, 0.5, "最初の特典");
        Coupon coupon2 = Coupon.getInstance(2, 0.25, "今月の特典");
        this.coupons = List.of(coupon1, coupon2);
    }

//    public void buyItem() {
//        //System.out.println(name + "さんが商品を購入しました。");
//        System.out.println(name + " purchased the item at 50% off");
//    }

//    public static Member getInstance(int id, String password, String name, int age, int rank) {
//        Member member = new Member(id, password, name, age, rank);
//        Coupon coupon1 = Coupon.getInstance(1, 0.5, "最初の特典");
//        Coupon coupon2 = Coupon.getInstance(2, 0.25, "今月の特典");
//
//        member.setCoupons(List.of(coupon1, coupon2));
//        return member;
//    }

    /**
     * 会員の情報を表示する。
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
     * 会員の情報を表示するメソッド
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
