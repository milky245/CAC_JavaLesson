/**
 ユーザーがじゃんけんの手を選択して対戦する機能を実装する。じゃんけんの手の選択は、
 ユーザーにじゃんけんの手を（0～2）を入力してもらい、勝負を 3 回繰り返す。
 コンピューターの手はランダムで決める。
 3 回勝負した結果が、ユーザー側が勝利した場合は、「〇対〇でプレイヤーの勝ちです！」と出
 力しシステムを終了させる。コンピューター側が勝利した場合は、「〇対〇でコンピューターの
 勝ちです！」と出力しシステムを終了させる。引き分けだった場合は、「〇対〇で引き分けです！」
 と出力しシステムを終了させる。〇の部分には勝ち数と負け数を表示すること。

 Ver1.0 ではクラスとメソッドは一つのみで構いません。
 例外処理は不要です、追加機能で実装してください。
 */
package standard;

import java.util.Scanner;

public class JankenV1 {

    public static final int GUU = 0;
    public static final int CHOKI = 1;
    public static final int PAA = 2;
    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        int playerWinCount = 0;
        int computerWinCount = 0;
        int drawCount = 0;

        int[] playerHand = new int[3];
        int[] computerHand = new int[3];
        Scanner sc = new Scanner(System.in);

        System.out.println("【じゃんけん開始】");
        for (int i = 0; i < 3; i++) {
            System.out.println("【" + (i + 1) + "回戦目】");
            System.out.print("プレイヤーの手を決めてください\n（0:グー、1:チョキ、2:パー）＞");
            playerHand[i] = sc.nextInt();
            computerHand[i] = (int)(Math.random() * 3);

            if (playerHand[i] == computerHand[i]) {
                drawCount++;
                System.out.println("引き分けです！");
            } else if ((playerHand[i] == GUU && computerHand[i] == CHOKI) ||
                    (playerHand[i] == CHOKI && computerHand[i] == PAA) ||
                    (playerHand[i] == PAA && computerHand[i] == GUU)) {
                playerWinCount++;
                System.out.println("プレイヤーが勝ちました！");
            } else {
                computerWinCount++;
                System.out.println("コンピューターが勝ちました！");
            }
        }

        System.out.println("【じゃんけん終了】");
        System.out.println(playerWinCount + "対" + computerWinCount + "で、");
        if (playerWinCount > computerWinCount) {
            System.out.println("プレイヤーの勝ちです！");
        } else if (playerWinCount < computerWinCount) {
            System.out.println("コンピューターの勝ちです！");
        } else {
            System.out.println("引き分けです！");
        }


    }

}
