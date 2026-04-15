package lesson05.challenge01;

//ここに次の条件を満たすクラスを作成してください。
//クラス名：Robot フィールド名：energy(int型)
public class Robot {
    public int energy;
    //フィールド名：name(String型)
    public String name;
    public int water;

    //メソッド名：pumpWater(引数なし、戻り値void、waterと出力するメソッド)
    public void pumpWater() {
        System.out.println("水を" + water + "リットル出します");
    }

    //「水を【※フィールドwaterの値】リットル出します」に出力を変更する
    public void randomWater() {
        water = (int) (Math.random() * 9) + 1;
        System.out.println("水を" + water + "リットル出します");
    }
    //メソッド名：setWater(引数int water、戻り値void、フィールドwaterに引数の値を代入する)
    public void setWater(int water) {
        this.water = water;
    }

    public void setRandomWater() {
        this.water = (int) (Math.random() * 9) + 1;
    }


    //メソッド名：makeOmelet(引数int eggNum ,int butterNum、戻り値void、入力されて材料の個数に併せてオムレツの個数を表示する)
    public void makeOmelet(int eggNum, int butterNum) {
        int omeletNum = Math.min(eggNum / 2, butterNum / 5);
        System.out.println(omeletNum + "人分のオムレツを作成しました。");
    }

    //メソッド名：makeEggDishes(引数int flourNum, int sugarNum, int eggNum, int butterNum、
    //戻り値String、作成できるメニューを戻り値として返す。また、作成できるメニューが無い場合はnull値を返す)
    // *  出来るとも。小麦粉170g、砂糖50g、卵1個、バター80gがそろえばクッキーを作る。
    // *
    // *  クッキーが出来ない場合で、卵2個、バター5gがそろえばオムレツを作る。
    // *
    // *  卵のみの場合はゆで卵を作る。
    // *
    // *  それ以外の場合は何も作らないようにするん
    public String makeEggDishes(int flourNum, int sugarNum, int eggNum, int butterNum) {
        if (flourNum >= 170 && sugarNum >= 50 && eggNum >= 1 && butterNum >= 80) {
            return "クッキー";
        } else if (eggNum >= 2 && butterNum >= 5) {
            return "オムレツ";
        } else if (eggNum >= 1) {
            return "ゆで卵";
        } else {
            return null;
        }
    }

    //return name
    public String getName() {
        return name;
    }
    public int getWater() {
        return water;
    }
}
