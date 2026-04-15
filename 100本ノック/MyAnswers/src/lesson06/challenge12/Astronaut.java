/**
 * 第6章 宇宙飛行士のお仕事
 *
 * 問題12 StringBufferクラス（replace）
 *
 * 宇宙船が次の目的地Ω星に到着しました。
 * Ω星は不思議な星です。Ω星では名前の
 * 末尾が数字が入っているものは英語表記に置き換える
 * というルールがあります。
 * 例えば、「apple2」は「appletwo」に
 * 「windows98」は「windows9eight」に変更されます。
 *
 * Ω星人クラスOmegalianを新たに作成してください。
 * OmegalianはString型フィールドitemを持ち、メソッドsetItem()で登録します。
 * また、setItem()内で呼び出されるメソッドとして、
 * 受け取った数字を英語表記に変換して戻す
 * private String changeLastChar(char ch)を持ちます。
 *
 * <実行例>
 *
 * Ω星人にアイテムを渡してください＞iPhone6
 *
 * Ω星人：
 * えっ！iPhonesixをくれるオメガか！
 * ありがとうオメガ。
 *
 */

package lesson06.challenge12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//ここにOmegalianクラスを記述する
class Omegalian {
    private String item;

    public void setItem(String item) {
        this.item = item;
        // Check if the last character is a digit
        if (!item.isEmpty() && Character.isDigit(item.charAt(item.length() - 1))) {
            char lastChar = item.charAt(item.length() - 1);
            String englishNumber = changeLastChar(lastChar);
            this.item = item.substring(0, item.length() - 1) + englishNumber;
        }
    }

    private String changeLastChar(char ch) {
        switch (ch) {
            case '0': return "zero";
            case '1': return "one";
            case '2': return "two";
            case '3': return "three";
            case '4': return "four";
            case '5': return "five";
            case '6': return "six";
            case '7': return "seven";
            case '8': return "eight";
            case '9': return "nine";
            default: return "";
        }
    }

    public String getItem() {
        return item;
    }
}


public class Astronaut {

    public static void main(String[] args) throws IOException {

        System.out.print("Ω星人にアイテムを渡してください＞");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String present = br.readLine();


        //ここに適切な処理を記述する
        Omegalian omegalian = new Omegalian();
        omegalian.setItem(present);


        System.out.println("\nΩ星人：");
        System.out.println("えっ！" + omegalian.getItem() + "をくれるオメガか！");
        System.out.println("ありがとうオメガ。");
    }
}
