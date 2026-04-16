package advanced.question07;

import java.io.IOException;
import java.util.Scanner;

/**
 * あなたは、新しく入社したプログラマー（システムエンジニア）です。今回、街の商店街にある、地域密着型の雑貨店「Happy
 * Shared Tools」に IT 化を通して業務支援を行うプロジェクトに参画することになりました。
 * 顧客となるこの店舗には、キッチン用品・文具・生活雑貨など、幅広い商品が並んでいます。当店舗の店長は、商品の管理を紙
 * の台帳で行っており、情報の検索や計算にとても時間がかかっています。今回、顧客の要望に対してシステム開発の提案を行うこ
 * とになりました。
 *   研修を終えたばかりのあなたは、まずは基本機能から順番にプログラム実装の業務を担当することになりました。段階的に機能
 * を追加しながら、最終的に商品の検索、集計ができるプログラムの製造を目指しましょう。
 * ※実際のシステム開発業務のプロセスを簡略化しています。 */


public class Question07_1 {

	//商品登録、商品一覧の機能
	//複数の商品、及び商品に紐づく単価（価格）を登録し、登録した商品を一覧表示する機能を実装する。
	public static void main(String[] args) throws IOException {

		// TODO:ここに実装
		String[] itemNames = new String[5];
		int[] itemPrices = new int[5];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < itemNames.length; i++) {
			System.out.println("商品" + (i+1) + "を入力してください:>");
			itemNames[i] = sc.nextLine();
		}
		System.out.println("各商品の単価を順に入力してください：");
		for (int i = 0; i < itemPrices.length; i++) {
			System.out.println(itemNames[i] + "の単価:>");
			itemPrices[i] = sc.nextInt();
		}

		System.out.println("登録商品一覧");
		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + " : " + itemPrices[i] + "円");
		}
		sc.close();

	}

}
