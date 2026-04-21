package excellence;
/*
* フィールド なし
* メソッド Main　
システムを開始した後、Player クラスを呼び出し、じゃんけん
の手を入力させる。その後、コンピューターの手をランダムで
決めた後に、JankenJudge クラスを呼び出し判定を行う。
3 回繰り返し、勝敗を表示し、システムを終了させる。
例外発生時や予期せぬエラーがあった場合はその旨のメッセー
ジを表示してシステムを終了させる。
* 戻り値 void
* 引数 String[] args
* **/

public class SystemMain {
        public static void main(String[] args) {
            try {
                Player player = new Player();
                JankenJudge judge = new JankenJudge();

                int playerWinCount = 0;
                int computerWinCount = 0;

                System.out.println("【じゃんけん開始】");
                for (int i = 0; i < 3; i++) {
                    System.out.println("【" + (i + 1) + "回戦目】");
                    int playerHand = player.getPlayerHand();
                    int computerHand = player.getComputerHand();

                    int result = judge.judge(playerHand, computerHand);
                    if (result == 1) {
                        playerWinCount++;
                    } else if (result == 2) {
                        computerWinCount++;
                    }
                }

                judge.printResult(playerWinCount, computerWinCount);

            } catch (Exception e) {
                System.out.println("エラーが発生しました: " + e.getMessage());
            }

        }
}
