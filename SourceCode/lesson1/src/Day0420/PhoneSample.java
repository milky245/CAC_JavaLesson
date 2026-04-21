package Day0420;

class Phone1301{
    int fee;
    double data;
    String owner;

    public Phone1301() {
        this.fee = 0;
        this.data = 0.0;
        this.owner = "Unknown";
    }
    //

    public void show() {
        System.out.println("料金は" + fee + "円です。");
        System.out.println("データ通信料は" + data + "GBです");
        //System.out.println("所有者は" + owner + "です。");
    }

    public void init(){
        this.fee = 100;
        this.data = 0.1;
        this.show();
    }

    public void update(int newFee,double newData){
        this.fee = newFee;
        this.data = newData;
        this.show();
    }

}

public class PhoneSample {
    public static void main(String[] args) {

//        Phone1301 phone_1 = new Phone1301();
//        phone_1.fee = 100000;
//        phone_1.data = 5.5555;
//
//        System.out.println("料金は" + phone_1.fee + "円です。");
//        System.out.println("データ通信料は" + phone_1.data + "GBです");
//
//        phone_1.owner = "Xue Zhihan";
//        System.out.println("所有者は" + phone_1.owner + "です。");

        Phone1301 phone_2 = new Phone1301();
        phone_2.init();
        phone_2.update(10000, 99.9);


    }
}
