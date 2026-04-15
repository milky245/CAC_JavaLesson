package lesson04.challenge06;
/**
* パッケージ名  lesson4.challenge06
* クラス名      Advertisement

* 処理の内容：募集要項の表示(以下の項目を表示し、詳細及び項目の追加等は自由とする)

*           ①店員募集のメッセージ
*           ②勤務時間
*           ③時給
*           ④待遇（制服の貸与など）*/

public class Advertisement {
    //成员变量包含店员工作时间（起始时间和结束时间）、时薪等信息
    //包含一个待遇子类，该类包含多个布尔值变量，表示是否提供制服、是否提供餐食，是否提供交通补贴等
    private String jobMessage;
    private int startTime;
    private int endTime;
    private int hourlyWage;
    private Benefits benefits;

    //构造方法初始化成员变量
    public Advertisement(String jobMessage, int startTime, int endTime, int hourlyWage, Benefits benefits) {
        this.jobMessage = jobMessage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hourlyWage = hourlyWage;
        this.benefits = benefits;
    }

    //方法用于显示招聘信息
    public void displayAdvertisement() {
        System.out.println(jobMessage);
        System.out.println("勤務時間: " + startTime + "時から" + endTime + "時まで");
        System.out.println("時給: " + hourlyWage + "円");
        System.out.println("待遇:");
        benefits.isTransportationAllowanceProvided();
        benefits.isUniformProvided();
        benefits.isMealProvided();
    }

    public static void main(String[] args) {
        Benefits benefits = new Benefits(true, true, true); // 交通費支給あり、制服貸与あり、朝食提供なし
        Advertisement advertisement = new Advertisement("店員募集！", 9, 17, 1200, benefits);
        advertisement.displayAdvertisement();
    }
}
