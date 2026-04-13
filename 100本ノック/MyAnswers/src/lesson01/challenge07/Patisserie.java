/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題7 10分割して販売する
 *
 * マカロンが大きすぎて売上が芳しくないので
 * 1個のマカロンを10分割して0.1個から販売することにします。
 * (値段も0.1倍～)
 * ただし合計金額と在庫は小数を切り捨て、
 * 合計金額は常に整数で表示します。
 *
 * 問題6の答えを改変し、以下の実行例を参考に処理を記述してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
 *
 * それぞれ何個ずつ買いますか？（最大30個まで）
 *
 * シトロン      >5
 * ショコラ      >1.5
 * ピスターシュ  >2.5
 *
 * シトロン     5.0個
 * ショコラ     1.5個
 * ピスターシュ 2.5個
 *
 * 合計個数    9.0個
 * 合計金額   2470円
 *
 * をお買いあげですね。
 * 承りました。
 *
 * 本日のおすすめ商品です。
 *
 * シトロン      \250 ・・・ 残り25個
 * ショコラ      \280 ・・・ 残り28個
 * ピスターシュ  \320 ・・・ 残り27個
 *
 */

package lesson01.challenge07;

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
            double citronOrder = scanner.nextDouble();
            System.out.print("ショコラ      >");
            double chocolatOrder = scanner.nextDouble();
            System.out.print("ピスターシュ  >");
            double pistacheOrder = scanner.nextDouble();

            double totalCount = citronOrder + chocolatOrder + pistacheOrder;
            int totalPrice = (int) ((citronOrder * 250) + (chocolatOrder * 280) + (pistacheOrder * 320));

            //在庫を減らす
            citron = citron - (int) citronOrder - 1;
            chocolat = chocolat - (int) chocolatOrder - 1;
            pistache = pistache - (int) pistacheOrder - 1;

            System.out.println("\nシトロン     " + citronOrder + "個");
            System.out.println("ショコラ     " + chocolatOrder + "個");
            System.out.println("ピスターシュ " + pistacheOrder + "個");
            System.out.println("\n合計個数    " + totalCount + "個");
            System.out.println("合計金額   " + totalPrice + "円");
            System.out.println("\nをお買いあげですね。");

            //在庫を減らした後の表示
            System.out.println("\n本日のおすすめ商品です。\n");
            System.out.printf("シトロン      \\250 ・・・ 残り%d個%n", citron);
            System.out.printf("ショコラ      \\280 ・・・ 残り%d個%n", chocolat);
            System.out.printf("ピスターシュ  \\320 ・・・ 残り%d個%n", pistache);
        }
}
