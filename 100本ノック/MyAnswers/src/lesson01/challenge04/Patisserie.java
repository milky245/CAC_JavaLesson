/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題4 注文を受ける
 *
 * 3種類のマカロンを任意の個数購入できるようにします。
 * [問題3]までの表示を行った後で
 * 実行例を参考に処理を追記してください。
 * （ >8 は >を表示した後で入力待ち状態になり、
 *   ユーザーがキーボードから8を入力したイメージです。）
 *
 *
 * <実行例>
 *
 * それぞれ何個ずつ買いますか？（最大30個まで）
 *
 * シトロン      >8
 * ショコラ      >2
 * ピスターシュ  >6
 *
 * シトロン     8個
 * ショコラ     2個
 * ピスターシュ 6個
 *
 * をお買いあげですね。
 * 承りました。
 */

package lesson01.challenge04;

public class Patisserie {
    public static void main(String[] args) {
        int citron = 30;
        int chocolat = 30;
        int pistache = 30;

        System.out.println("本日のおすすめ商品です。\n");
        System.out.printf("シトロン      \\250 ・・・ 残り%d個%n", citron);
        System.out.printf("ショコラ      \\280 ・・・ 残り%d個%n", chocolat);
        System.out.printf("ピスターシュ  \\320 ・・・ 残り%d個%n", pistache);

        System.out.println("\nそれぞれ何個ずつ買いますか？（最大30個まで）\n");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("シトロン      >");
        int citronOrder = scanner.nextInt();
        System.out.print("ショコラ      >");
        int chocolatOrder = scanner.nextInt();
        System.out.print("ピスターシュ  >");
        int pistacheOrder = scanner.nextInt();

        System.out.println("\nシトロン     " + citronOrder + "個");
        System.out.println("ショコラ     " + chocolatOrder + "個");
        System.out.println("ピスターシュ " + pistacheOrder + "個");
        System.out.println("\nをお買いあげですね。");
        System.out.println("承りました。");

    }

}
