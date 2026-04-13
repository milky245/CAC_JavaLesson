/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題6  在庫を減らす
 *
 * [問題5]までの表示を行った後で
 * 3種のマカロンそれぞれの在庫を減らす処理を追記し
 * 以下の実行例と同じものを最後に表示してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
 *
 * 本日のおすすめ商品です。
 *
 * シトロン      \250 ・・・ 残り22個
 * ショコラ      \280 ・・・ 残り28個
 * ピスターシュ  \320 ・・・ 残り24個
 *
 */

package lesson01.challenge06;

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

        int totalCount = citronOrder + chocolatOrder + pistacheOrder;
        int totalPrice = (citronOrder * 250) + (chocolatOrder * 280) + (pistacheOrder * 320);

        //在庫を減らす
        citron -= citronOrder;
        chocolat -= chocolatOrder;
        pistache -= pistacheOrder;

        System.out.println("\nシトロン     " + citronOrder + "個");
        System.out.println("ショコラ     " + chocolatOrder + "個");
        System.out.println("ピスターシュ " + pistacheOrder + "個");
        System.out.println("\n合計個数    " + totalCount + "個");
        System.out.println("合計金額  " + totalPrice + "円");
        System.out.println("\nをお買いあげですね。");

        //在庫を減らした後の表示
        System.out.println("\n本日のおすすめ商品です。\n");
        System.out.printf("シトロン      \\250 ・・・ 残り%d個%n", citron);
        System.out.printf("ショコラ      \\280 ・・・ 残り%d個%n", chocolat);
        System.out.printf("ピスターシュ  \\320 ・・・ 残り%d個%n", pistache);
    }

}
