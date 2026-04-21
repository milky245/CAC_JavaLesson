package extra;
//Ver3.0 に下記機能を追加すること。クラスやメソッドは今までの学習内容を参考に独自で追
//加して構わない。
//
//① 対戦回数を自由に選択できるようにする。
//コンソール上に表示する内容は自由に決めて構わない。ユーザーの使いやすさを考えること。
//
//② コンピューターの手をランダムではなく戦略性を実装すること。
//例：同じ手を連続でださない、ユーザーの手を真似る
//パターンに関しては自由に決めて構わない。何でも良いのでひとつ実装をすること。
//
//③ 対戦人数を自由に選択できるようにする。
//コンピューターの人数を増やし、判定を実施する。
//現実世界の多人数のじゃんけんと同様のルールで機能実施すること。
//コンソール上に表示する内容は自由に決めて構わない。ユーザーの使いやすさを考えること。

import java.util.*;

// JankenJudge クラス (JankenJudge.java) …… じゃんけんの判定クラス
public class JankenJudge {

    //use enum to represent the result of each round
    public enum Result {
        WIN, LOSE, DRAW
    }
    public static List<Integer> judgeRound(int playerHand, List<Integer> computerHands){

        Set<Integer> allHands = new HashSet<>(computerHands);
        allHands.add(playerHand);

        //there are all 3 hands or all same hand--again
        if (allHands.size() == 3 || allHands.size() == 1){

            return null;
        }

        List<Integer> winners = new ArrayList<>();

        boolean playerWin = false;
        boolean playerLose = false;

        //for each computer hand, compare with player hand and add the winner to the list
        //if player not lose, these winners will get into next round
        for (int i = 0; i < computerHands.size(); i++){
            Result res = win(playerHand, computerHands.get(i));
            if (res == Result.LOSE){
                winners.add(i);
                playerLose = true;
            }else if(res == Result.WIN){
                playerWin = true;
            }
        }
        //if one computer hand wins, set player wins false
        //boolean playerWin = true;
        if (playerLose){
            return new ArrayList<>();
        }
        //at least won one bot, and nobody won player
        if (playerWin){
            winners.add(-1);
            //-1 represents player
            // the only -1 in it means player win
        }
        return winners;

    }

    private static Result win(int hand1, int hand2){
        if (hand1 == hand2){
            return Result.DRAW;
        }
        if ((hand1 - hand2 + 3) % 3 == 1){
            return Result.WIN;
        }
        else{
            return Result.LOSE;
        }
    }

}
