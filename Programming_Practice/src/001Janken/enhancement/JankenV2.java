package enhancement;
/*
Ver2.0 機能要件
Ver1.0 で作成したクラスの main メソッドから throws IOException を外し、main メソッ
ド内で例外処理を行うように変更する。また、ユーザーが入力したじゃんけんの手が数値で入
力されているが、誤っている場合（4 や 100 や-5）は再度入力させるように変更する。
(※パッケージを分け、クラスを再度作成してください)

2-1 例外発生時に出力するメッセージ

システムエラーが発生しました。
システムを終了します。

2-2 じゃんけんの手を再度入力させる時に出力するメッセージ
入力した値が誤っています、再度入力してください
 */

import java.io.IOException;
import java.util.Scanner;

public class JankenV2 {
    public static final int GUU = 0;
    public static final int CHOKI = 1;
    public static final int PAA = 2;
    public static void main(String[] args) throws IOException
    {
        try{
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

                if (playerHand[i] < 0 || playerHand[i] > 2) {
                    System.out.println("入力した値が誤っています、再度入力してください");
                    i--; // ループのカウンタを減らして再度入力させる
                    continue; // 次のループへ
                }

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
        catch (Exception e){
            System.out.println("システムエラーが発生しました。");
            System.out.println("システムを終了します。");
        }
    }
}
