package Day0422;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//正規表現を表す Pattern クラスとそれに対応した問い合わせの結果を保持する Matcher クラスを別々
//にすることで概念的に分けています。下記の流れに沿って各クラスを利用しましょう。
//
//
//
//① 正規表現パターンをコンパイルして Pattern オブジェクトを生成
//② 正規表現を適用したいテキストを渡して、Matcher オブジェクト生成
//③ Matcher により、検索・置換・分割などを実施
//
//
//
//なお、Matcher クラスの find()メソッドは正規表現にマッチした部分を見つけると、「マッチした範囲
//の末尾の位置」まで進みます。次の呼び出しでは、その末尾の直後の文字位置から検索を再開します。そ
//のため、同じ文字列を最初からもう一度調べたい場合は、Matcher クラスの reset()メソッド等を使用し
//て位置をリセットすることができます。
public class Sample1907 {

    public static void main(String[] args) throws IOException {

        System.out.println("電話番号を入力してください");
        System.out.println("入力例:xxx-xxxx-xxxx");

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // パターンを指定
        Pattern p = Pattern.compile("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");
        // パターンにマッチしているか比較
        Matcher m = p.matcher(str);
        //System.out.println(m.find());
        if (m.matches()) {
            System.out.println("正しい電話番号です");
        } else {
            System.out.println("形式が正しくありません");
        }
    }
}
