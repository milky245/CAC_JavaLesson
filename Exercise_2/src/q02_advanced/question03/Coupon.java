package q02_advanced.question03;
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
     * クーポンのインスタンスを生成するファクトリーメソッド
     * @param id クーポンID
     * @param discountRate 割引率
     * @param description 説明
     * @return クーポンのインスタンス
     */
    public static Coupon getInstance(int id, double discountRate, String description) {
        return new Coupon(id, discountRate, description);
    }
}
