package Day0424;

public class Chef2301 extends Worker2301 {
    public Chef2301(String name, int age) {
        super(Constant2301.CHEF, name, age);

    }

    public void doWork() {
        System.out.println("食事を作ります。");
    }
}
