package excellence;

import java.util.Scanner;

//Player クラス (Player.java) …… プレイヤークラス、キーボード入力処理などを実装
// また、コンピューターのじゃんけんの手も Player クラスに実装すること
public class Player {
        public static final int GUU = 0;
        public static final int CHOKI = 1;
        public static final int PAA = 2;


        public int getPlayerHand() {

            Scanner sc = new Scanner(System.in);
            System.out.print("プレイヤーの手を決めてください\n（0:グー、1:チョキ、2:パー）＞");
            int hand = sc.nextInt();
            while (hand < 0 || hand > 2) {
                System.out.println("入力した値が誤っています、再度入力してください");
                System.out.print("プレイヤーの手を決めてください\n（0:グー、1:チョキ、2:パー）＞");
                hand = sc.nextInt();
            }
            return hand;
        }

        public int getComputerHand() {
            // コンピューターの手をランダムに決める処理を実装
            return (int)(Math.random() * 3); // 0～2のランダムな値を返す
        }
}
