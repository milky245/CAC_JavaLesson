package lesson05.challenge09;

import java.util.Arrays;
import lesson05.challenge01.Robot;

public class ClearRobot {
    //クラス名：ClearRobot
    //メソッド名：clearTable(引数int[] ingredients
    //戻り値void、渡された配列を0でクリアする)
    public void clearTable(int[] ingredients) {
        Arrays.fill(ingredients, 0);
    }
}
