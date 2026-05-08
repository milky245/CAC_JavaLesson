package model;

import java.util.Random;

public class PCTeam extends Team {

    private Random random;

    public PCTeam() {
        // 初始化电脑队
        super("コンピュータのチーム");
        this.random = new Random();
    }

    public Hand chooseHand() {
        // 随机生成手势
        int handNumber = random.nextInt(3) + 1;
        return Hand.fromNumber(handNumber);
    }
}
