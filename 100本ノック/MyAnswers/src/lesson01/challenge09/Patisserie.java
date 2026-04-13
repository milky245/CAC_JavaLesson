/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題9 新商品の開発
 *
 * 翌日から新商品を発売することにしました。
 * 新商品の名前は「三色マカロン」です。
 * シトロン、ショコラ、ピスターシュの３つの味が
 * 1個のマカロンに集約されているのが特徴で、
 * その配合率は前日の売上比で決まり、
 * 価格はマカロン１個あたりの平均売上価格に準じて
 * 自動的に決定されます。（ただし、1の位は切り捨て）
 *
 * 以下の実行例を参考に処理を追記、改変してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
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
 * 明日の三色マカロンの配合率が決まりました！
 *
 * シトロンの味    ・・・ 50%
 * ショコラの味    ・・・ 17%
 * ピスターシュの味・・・ 32%
 *
 * が楽しめます！
 *
 * 値段は\270です。
 *
 */

package lesson01.challenge09;

public class Patisserie {
    public static void main(String[] args) {

        System.out.println("たいへんお待たせしました。");
        System.out.println("【ポエール・ネルメ】");
        System.out.println("ただいまより開店です！！");

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

        System.out.println("\n明日の三色マカロンの配合率が決まりました！\n");
        System.out.printf("シトロンの味    ・・・ %d%%%n", (int) ((citronOrder * 250 / totalPrice) * 100));
        System.out.printf("ショコラの味    ・・・ %d%%%n", (int) ((chocolatOrder * 280 / totalPrice) * 100));
        System.out.printf("ピスターシュの味・・・ %d%%%n", (int) ((pistacheOrder * 320 / totalPrice) * 100));
        System.out.println("\nが楽しめます！\n");
        double macaronPrice = totalPrice / totalCount;
        System.out.printf("値段は\\%.1fです。%n", macaronPrice);
    }

}
