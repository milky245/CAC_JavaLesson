package extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

//Player クラス (Player.java) …… プレイヤークラス、キーボード入力処理などを実装
// また、コンピューターのじゃんけんの手も Player クラスに実装すること
public class Player {
    private List<Integer> history = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public int getPHand(){
        System.out.print("プレイヤーの手を決めてください\n（0:グー、1:チョキ、2:パー）＞");
        int hand = sc.nextInt();
        while (hand < 0 || hand > 2) {
            System.out.println("入力した値が誤っています、再度入力してください");
            System.out.print("プレイヤーの手を決めてください\n（0:グー、1:チョキ、2:パー）＞");
            hand = sc.nextInt();
        }
        history.add(hand);
        return hand;
    }

    public List<Integer> getHistory(){
        return history;
    }
}
