/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題8 閉店作業を行う
 *
 * 閉店時間となったため、閉店メッセージを表示し
 * 売上の割合を確認します。
 * 以下の実行例を参考に処理を追記、改変してください。
 * （%の表示は小数第一位切り捨てで行います。）
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
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
 * 閉店時間となりました。
 * またのお越しをお待ちしております。
 *
 * 売上の割合
 * 売上合計      \2470
 *
 * 内訳
 * シトロン      \1250・・・ 50%
 * ショコラ      \420・・・ 17%
 * ピスターシュ  \800・・・ 32%
 *
 */

package lesson01.challenge08;

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

        System.out.println("\n閉店時間となりました。");
        System.out.println("またのお越しをお待ちしております。");
        System.out.println("\n売上の割合");
        System.out.println("売上合計      \\" + totalPrice);
        System.out.println("\n内訳");
        System.out.printf("シトロン      \\%d・・・ %d%%%n", (int) (citronOrder * 250), (int) ((citronOrder * 250 / totalPrice) * 100));
        System.out.printf("ショコラ      \\%d・・・ %d%%%n", (int) (chocolatOrder * 280), (int) ((chocolatOrder * 280 / totalPrice) * 100));
        System.out.printf("ピスターシュ  \\%d・・・ %d%%%n", (int) (pistacheOrder * 320), (int) ((pistacheOrder * 320 / totalPrice) * 100));

    }

}
