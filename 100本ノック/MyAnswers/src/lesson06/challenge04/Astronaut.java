/**
 * 第6章 宇宙飛行士のお仕事
 *
 * 問題4 宇宙船に初期値を代入①
 *
 * 宇宙船クラス（Spaceship）のフィールドに初期値を
 * 設定するコンストラクタを追加します。
 *
 * 宇宙船の空気タンクと燃料タンクにそれぞれ100を初期値として
 * 代入する引数なしのコンストラクタを追加してください。
 *
 * <実行例>
 * 空気の初期値は：【コンストラクタで設定した値】リットルです。
 * 燃料の初期値は：【コンストラクタで設定した値】ガロンです。
 *
 */

package lesson06.challenge04;

class Spaceship {
    private int air;
    private int fuel;

    //ここに適切な処理を記述する。
    public Spaceship() {
        this.air = 100;
        this.fuel = 100;
    }

    public Spaceship(int air, int fuel) {
        this.air = air;
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

}

public class Astronaut {

    public static void main(String[] args) {

        //ここに適切な処理を記述する。
        Spaceship spaceship1 = new Spaceship();
        System.out.println("spaceship1-引数なし");
        System.out.println("空気の初期値は：" + spaceship1.getAir() + "リットルです。");
        System.out.println("燃料の初期値は：" + spaceship1.getFuel() + "ガロンです。");
        Spaceship spaceship2 = new Spaceship(200, 300);
        System.out.println("spaceship2-引数あり");
        System.out.println("空気の初期値は：" + spaceship2.getAir() + "リットルです。");
        System.out.println("燃料の初期値は：" + spaceship2.getFuel() + "ガロンです。");

    }
}
