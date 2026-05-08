package q02_advanced.question01;
/**
 * クーポンを表すクラス
 * クーポンのID、割引率、説明をフィールドとして持ち、クーポンの情報を表示するメソッドを持つ。
 */
public class Coupon {
    private int id;
    private double discountRate;
    private String description;

    public Coupon() {
    }

    /**
     * 引数ありのコンストラクタを定義する。引数で取得した値をフィールドに代入する。
     */
    public Coupon(int id, double discountRate, String description) {
        this.id = id;
        this.discountRate = discountRate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * クーポンの情報を表示するメソッド
     */
    @Override
    public String toString() {
        return "Coupon [" +
                "id=" + id +
                ", discountRate=" + discountRate +
                ", description='" + description +
                ']';
    }

    /**
     * getInstance メソッドを定義する。引数で取得した id、discountRate、description を使用して Coupon クラスオブジェクトを生成し、戻り値として返す。
     */
    public static Coupon getInstance(int id, double discountRate, String description) {
        return new Coupon(id, discountRate, description);
    }
}