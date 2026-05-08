package model;

import java.util.Scanner;

public class PlayerTeam extends Team {

    private Scanner scanner;

    public PlayerTeam() {
        // 初始化玩家队
        super("プレイヤーのチーム");
        this.scanner = new Scanner(System.in);

    }

    public Hand chooseHand() {
        // 读取玩家输入
        // 返回 Hand
        while (true) {
            System.out.print("出す手を入力してください（1: グー, 2: チョキ, 3: パー）: ");
            String input = scanner.nextLine();
            try {
                int handNumber = Integer.parseInt(input);
                return Hand.fromNumber(handNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("無効な入力です。もう一度入力してください。");
            }
        }
    }
}
