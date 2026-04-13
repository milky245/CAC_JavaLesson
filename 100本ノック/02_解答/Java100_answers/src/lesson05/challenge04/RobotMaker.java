/**
 * 第5章 ロボット工場のお仕事
 *
 * 問題4  機能から別機能を呼び出す
 *
 * メソッド内で別のメソッドを呼び出します。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  Rさん：
 *  でもいつも1リットルじゃつまらないですね。
 *
 *  G博士：
 *  じゃあ自分で改造すればいいんじゃ。わしゃ知らん。
 *
 *  Rさん：
 *  え、これ改造していいんですか？
 *
 *  G博士：
 *  いいぞ。出来るならな。
 *
 *  Rさん：
 *  ......改造終わりました。
 *
 *  G博士：
 *  本当か！どれどれ
 *
 *  水を【※ここに1～9の乱数を出力】リットル出します
 *
 *  G博士：
 *  ......確かに出来とる。
 *
 */

package lesson05.challenge04;

class Robot {
    int energy;
    int water;
    String name;

    void pumpWater() {
        randomWater();
        System.out.println("水を"+water+"リットル出します。\n");

    }
    void randomWater() {
        water = (int)(Math.random()*10) % 9 + 1;
    }
}

public class RobotMaker {

    public static void main(String[] args) {

        System.out.println("Rさん：");
        System.out.println("でもいつも1リットルじゃつまらないですね。\n");
        System.out.println("G博士：");
        System.out.println("じゃあ自分で改造すればいいんじゃ。わしゃ知らん。\n");
        System.out.println("Rさん：");
        System.out.println("え、これ改造していいんですか？\n");
        System.out.println("G博士：");
        System.out.println("いいぞ。出来るならな。\n");
        System.out.println("Rさん：");
        System.out.println("......改造終わりました。\n");
        System.out.println("G博士：");
        System.out.println("本当か！どれどれ\n");

        Robot robot = new Robot();
        robot.pumpWater();

        System.out.println("G博士：");
        System.out.println("......確かに出来とる。\n");
    }

}
