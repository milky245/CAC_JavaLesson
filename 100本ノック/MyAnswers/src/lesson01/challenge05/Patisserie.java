/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題5 合計金額を求める
 *
 * 入力されたマカロンの個数から合計購入数、合計金額を求めます。
 * 合計購入数、合計金額を求める処理を追記した後で
 * [問題4]の表示を実行例を参考にして改変してください。
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
 * 合計個数    16個
 * 合計金額  4480円
 *
 * をお買いあげですね。
 * 承りました。
 *
 */

package lesson01.challenge05;

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

        System.out.println("\nシトロン     " + citronOrder + "個");
        System.out.println("ショコラ     " + chocolatOrder + "個");
        System.out.println("ピスターシュ " + pistacheOrder + "個");
        System.out.println("\n合計個数    " + totalCount + "個");
        System.out.println("合計金額  " + totalPrice + "円");
        System.out.println("\nをお買いあげですね。");
        System.out.println("承りました。");

    }

}
