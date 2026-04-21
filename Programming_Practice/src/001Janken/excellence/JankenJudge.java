package excellence;
// JankenJudge クラス (JankenJudge.java) …… じゃんけんの判定クラス
public class JankenJudge {
    public int judge(int playerHand, int computerHand) {
        if (playerHand == computerHand) {
            System.out.println("引き分けです！");
            return 0;
        } else if ((playerHand == Player.GUU && computerHand == Player.CHOKI) ||
                (playerHand == Player.CHOKI && computerHand == Player.PAA) ||
                (playerHand == Player.PAA && computerHand == Player.GUU)) {
            System.out.println("プレイヤーが勝ちました！");
            return 1;
        } else {
            System.out.println("コンピューターが勝ちました！");
            return 2;
        }
    }

    public void printResult(int playerWinCount, int computerWinCount) {
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
