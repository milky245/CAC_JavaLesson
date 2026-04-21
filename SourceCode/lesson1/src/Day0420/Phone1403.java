package Day0420;


public class Phone1403 {

    int fee;
    double data;
    String owner;

    public Phone1403() {
        this.fee = 0;
        this.data = 0.0;
        this.owner = "Unknown";
    }

    public void show() {
        System.out.println("料金は" + fee + "円です。");
        System.out.println("データ通信料は" + data + "GBです");
        //System.out.println("所有者は" + owner + "です。");
    }

}
