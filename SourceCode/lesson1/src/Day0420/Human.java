package Day0420;
//追加 Humanクラスでsellメソッドを定義して実行しましょう
//戻り値の型 Phone1403
//メソッド名 sell
//引数 ()
//処理
//			・Phone1401 phone = new Phone1401();
//			・phone.fee=10000;
//			・phone.data=3.3;
//			・return phone;

//mainメソッドでは以下の処理で戻り値を受け取って処理
//		Phone1403 soldPhone = satou.sell();
//		soldPhone.show();
public class Human {
    String sei;
    String mei;
    double height;
    double weight;

    public Human() {
        this.sei = "佐藤";
        this.mei = "太郎";
        this.height = 1.75;
        this.weight = 70.0;
    }

    public Human(String sei, String mei) {
        this.sei = sei;
        this.mei = mei;
    }

    public String showFullName(String sei, String mei) {
        return sei + mei;
    }

    public double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    public Phone1403 sell() {

        Phone1403 phone = new Phone1403();

        phone.fee = 10000;
        phone.data = 3.3;
        return phone;
    }

}
