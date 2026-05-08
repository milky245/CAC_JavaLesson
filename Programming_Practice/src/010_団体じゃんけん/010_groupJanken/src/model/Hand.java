package model;

public enum Hand {

    ROCK(1, "グー"),
    SCISSORS(2, "チョキ"),
    PAPER(3, "パー");

    private int number;
    private String displayName;

    Hand(int number, String displayName) {
        // 初始化
        this.number = number;
        this.displayName = displayName;
    }

    public int getNumber() {
        // 返回输入编号
        return number;
    }

    public String getDisplayName() {
        // 返回日文显示
        return displayName;
    }

    public static Hand fromNumber(int number) {
        // 根据输入返回对应 Hand
        for (Hand hand : Hand.values()) {
            if (hand.getNumber() == number) {
                return hand;
            }
        }
        throw new IllegalArgumentException("Invalid hand number: " + number);
    }
}
