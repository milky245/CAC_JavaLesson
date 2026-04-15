package lesson04.challenge06;

public class Benefits {
    private final boolean transportationAllowanceProvided;
    private final boolean uniformProvided;
    private final boolean mealProvided;

    //构造方法初始化成员变量

    public Benefits(boolean transportationAllowanceProvided, boolean uniformProvided, boolean mealProvided) {
        this.transportationAllowanceProvided = transportationAllowanceProvided;
        this.uniformProvided = uniformProvided;
        this.mealProvided = mealProvided;
    }

    //设定常规初始化对象的默认方法
    public Benefits() {
        this.transportationAllowanceProvided = true;
        this.uniformProvided = true;
        this.mealProvided = true;
    }
    public void isTransportationAllowanceProvided() {
        if (transportationAllowanceProvided) {
            System.out.println("- 交通費の支給");
        }
        else{
            System.out.println("- 交通費の支給なし");
        }
    }

    public void isUniformProvided() {
        if (uniformProvided) {
            System.out.println("- 制服の貸与");
        }
        else{
            System.out.println("- 制服の貸与なし");
        }
    }

    public void isMealProvided() {
        if (mealProvided) {
            System.out.println("- 朝食の提供");
        }
        else{
            System.out.println("- 朝食の提供なし");
        }

    }
}
