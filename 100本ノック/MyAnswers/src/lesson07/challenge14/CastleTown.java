/**
 * 第7章 武士のお仕事
 *
 * 問題14 複数のインターフェースを実装する
 *
 * 勘定奉行インタフェース、文化人インターフェースを実装する。
 *
 * 藩士クラスに勘定奉行インターフェースと文化人インターフェースを
 * 実装してください。
 *
 * <実行例>
 * 藩士1：
 * 藩の資産を計算するよ～。
 * 茶道を嗜むよ～。
 *
 */

package lesson07.challenge14;


//ここにIChiefTreasurerインターフェースを記述
interface IChiefTreasurer {

    void figure();

}


//ここにICelebrityインターフェースを記述
interface ICelebrity {

    void learn();

}


//ここにSamuraiクラスを記述
class Samurai {

    void fight() {
        System.out.println("戦うよ～。");
    }

}


//ここにRetainerクラスを記述
class Retainer extends Samurai implements IChiefTreasurer, ICelebrity {

    void getSalary() {
        System.out.println("給料をもらうよ～。");
    }

    //@Override
    public void figure() {
        System.out.println("藩の資産を計算するよ～。");
    }

    //@Override
    public void learn() {
        System.out.println("茶道を嗜むよ～。");
    }

}


public class CastleTown {

    public static void main(String[] args) {
        System.out.println("藩士1：");


        //ここに適切な処理を記述;
        Retainer retainer1 = new Retainer();
        retainer1.figure();
        retainer1.learn();

    }
}
