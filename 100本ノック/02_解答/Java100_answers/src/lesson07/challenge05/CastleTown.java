/**
 * 第7章 武士のお仕事
 *
 * 問題5  オーバーライド②
 *
 * 侍クラス（Samurai）のメソッドをオーバーライドする。
 *
 * 侍クラス（Samurai）のwork()メソッド（戻り値void）を、
 * 浪人クラスでオーバーライドしてください。
 *
 * <実行例>
 * 侍は働きます。
 *
 * 侍1：
 * 何かして働くよ～。
 *
 * 具体的に言うと浪人は傘張りをします。
 *
 * 浪人1：
 * 傘張るよ～。
 *
 */

package lesson07.challenge05;

class Samurai {

    void fight() {
        System.out.println("戦うよ～。");
    }

    void work() {
        System.out.println("何かして働くよ～");
    }

}

class Ronin extends Samurai {

    void covered(){
        System.out.println("傘張りするよ～。");
    }

    void work() {
        System.out.println("傘張るよ～。");
    }
}


public class CastleTown {

    public static void main(String[] args) {
        System.out.println("侍は働きます。\n");

        System.out.println("侍1：");

        Samurai samurai1 = new Samurai();
        samurai1.work();

        System.out.println("\n具体的に言うと浪人は傘張りをします。\n");

        System.out.println("浪人1：");

        Ronin ronin1 = new Ronin();
        ronin1.work();

    }
}
