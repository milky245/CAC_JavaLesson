package Day0427;

public class Phone2601 {

    private int fee;
    private double data;

    /**
     * @param fee
     * @param data
     */
    public Phone2601(int fee, double data) {
        this.fee = fee;
        this.data = data;
    }

    /**
     * @return fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @param fee セットする fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * @return data
     */
    public double getData() {
        return data;
    }

    /**
     * @param data セットする data
     */
    public void setData(double data) {
        this.data = data;
    }

}
