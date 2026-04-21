package extra;
/*

*/

import java.util.*;

public class SystemMain {
        public static void main(String[] args) {
            try {
                Scanner sc = new Scanner(System.in);
                int rounds = 0;
                int botNum = 0;
                do{
                    System.out.println("対戦回数を入力してください（3回以上）：＞");
                    rounds = sc.nextInt();

                    System.out.println("ボットの人数を入力してください（1人以上）：＞");
                    botNum = sc.nextInt();
                }while (rounds < 3 || botNum < 1);

                Player player = new Player();
                List<ComputerPlayer> bots = new ArrayList<>();

                for (int i = 0; i < botNum; i++) {
                    bots.add(new ComputerPlayer());
                }

                int playerScore = 0;
                int botScore = 0;

                for (int i = 0; i < rounds; i++){

                    System.out.println("【" + (i + 1) + "回戦目】");
                    List<ComputerPlayer> aliveBots = new ArrayList<>(bots);

                    while(true){
                        int pHand = player.getPHand();
                        List<Integer> botHands = new ArrayList<>();
                        //bot按照策略出手，获得bot的手型
                        for(ComputerPlayer bot : aliveBots){
                            botHands.add(bot.play(player.getHistory()));
                        }

                        List<Integer> result = JankenJudge.judgeRound(pHand, botHands);
                        //进行每轮的结果判定
                        //get the hand from each bots
                        for (int j = 0; j < aliveBots.size(); j++) {
                            System.out.println("ボット" + (j + 1) + "の手: " + botHands.get(j));
                        }
                        if (result == null){
                            System.out.println("勝った人がいない、再戦です！");
                            continue;
                        }
                        if (result.isEmpty()){
                            System.out.println("プレイヤーが負けです！");
                            botScore++;
                            break;
                        }
                        //only player left alive
                        if (result.size() == 1 && result.get(0) == -1){
                            System.out.println("プレイヤーが勝ちです！");
                            playerScore++;
                            break;
                        }

                        //calculate the alive characters and continue
                        List<ComputerPlayer> nextBots = new ArrayList<>();
                        for (int idx : result){
                            if (idx != -1){
                                nextBots.add(aliveBots.get(idx));
                            }
                        }
                        aliveBots = nextBots;
                        System.out.println("続けて対戦します！残りのボットの人数: " + aliveBots.size());
                    }
                }

                System.out.println("最終結果:");

                System.out.println("プレイヤーの勝ち数: " + playerScore);
                System.out.println("ボットの勝ち数: " + botScore);

                if (playerScore > botScore){
                    System.out.println("プレイヤーの勝ちです！");
                } else if (playerScore < botScore){
                    System.out.println("ボットの勝ちです！");
                } else {
                    System.out.println("引き分けです！");
                }

            } catch (Exception e) {
                System.out.println("エラーが発生しました: " + e.getMessage());
            }

        }
}
