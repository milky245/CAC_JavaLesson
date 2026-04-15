/**
 * 第4章 倉庫番のお仕事
 *
 * 問題11 荷物の入れ替え（三つの配列をまとめる）
 *
 * MQ運送から、新たに三つのコンテナ群を預かり
 * 委託管理を行うことになりました。
 * 三つのコンテナ群はそれぞれ5箱ずつからなり、
 * 合計すると15箱の入れ物になります。
 *
 * 併せてMQ運送から依頼があり、
 * コンテナ群のうち空き箱がいくつかあるので、
 * 空いてるところは詰めてほしいと言われました。
 * つまり、
 *
 * 有、空、有、空、有
 *
 * と並んでいた場合は、
 *
 * 有、有、有、空、空
 *
 * としてほしいという依頼です。
 *
 * 各コンテナのどの箱が空き箱なのかはランダムに決定し、
 * 空き箱である確率は1/4です。
 * 中身がある箱には1～10の何れかの数値が入り、
 * これもランダムに決定します。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  MQ運送の件、お願いします。
 *
 *  Yさん：
 *  はい、まずは現状から確認いたします。
 *
 *  C...3,4,4,0,7
 *
 *  D...0,5,0,9,0
 *
 *  E...2,1,3,10,6
 *
 *  でした。直してきます...
 *
 *  Yさん：
 *  直してきました。
 *
 *  C...3,4,4,7,5
 *
 *  D...9,2,1,3,10
 *
 *  E...6,0,0,0,0
 *
 *  になりました。
 *
 *  E主任：
 *  ご苦労さまでした。
 *
 */

package lesson04.challenge11;

public class WarehouseManager {

	public static void main(String[] args) {


		//ここに必要な配列の宣言を記述する。
		int[][] containers = new int[3][5];


		//ここに配列に値を代入する処理を記述する。(要素はランダム)
		for (int i = 0; i < containers.length; i++) {
			for (int j = 0; j < containers[i].length; j++) {
				if (Math.random() < 0.25) { // 1/4の確率で空き箱
					containers[i][j] = 0;
				} else {
					containers[i][j] = (int) (Math.random() * 10) + 1;
				}
			}
		}


		System.out.println("E主任：");
		System.out.println("MQ運送の件、お願いします。\n");

		System.out.println("Yさん：");
		System.out.println("はい、まずは現状から確認いたします。\n");

		System.out.print("C...");


		//ここに配列Cの要素をすべて出力する処理を記述する。
		WarehouseManager.printContainer(containers[0]);


		System.out.print("\n\nD...");


		//ここに配列Dの要素をすべて出力する処理を記述する。
		WarehouseManager.printContainer(containers[1]);


		System.out.print("\n\nE...");


		//ここに配列Eの要素をすべて出力する処理を記述する。
		WarehouseManager.printContainer(containers[2]);


		System.out.println("\n\nでした。直してきます...\n");


		//ここに詰め替え処理を記述する
		// 3行の配列の0を、各行の末尾ではなく、全体の2次元配列の末尾に移動させる。
		//まず、全ての要素を1次元配列にコピーする。
		int[] allBoxes = new int[containers.length * containers[0].length];
		int index = 0;
		for (int i = 0; i < containers.length; i++) {
			for (int j = 0; j < containers[i].length; j++) {
				allBoxes[index++] = containers[i][j];
			}
		}
		// 将非零元素移到前面，零元素移到后面
		int nonZeroIndex = 0;
		for (int i = 0; i < allBoxes.length; i++) {
			if (allBoxes[i] != 0) {
				allBoxes[nonZeroIndex++] = allBoxes[i];
			}
		}
		while (nonZeroIndex < allBoxes.length) {
			allBoxes[nonZeroIndex++] = 0;
		}
		//　最後の要素から詰め替えるため、1次元配列の先頭から順に2次元配列にコピーする。
		index = 0;
		for (int i = 0; i < containers.length; i++) {
			for (int j = 0; j < containers[i].length; j++) {
				containers[i][j] = allBoxes[index++];
			}
		}

		System.out.println("Yさん：");
		System.out.println("直してきました。\n");

		System.out.print("C...");


		//ここに配列Cの要素をすべて出力する処理を記述する。
		WarehouseManager.printContainer(containers[0]);


		System.out.print("\n\nD...");


		//ここに配列Dの要素をすべて出力する処理を記述する。
		WarehouseManager.printContainer(containers[1]);


		System.out.print("\n\nE...");


		//ここに配列Eの要素をすべて出力する処理を記述する。
		WarehouseManager.printContainer(containers[2]);


		System.out.println("\n\nになりました。\n");

		System.out.println("E主任：");
		System.out.println("ご苦労さまでした。");
	}

	public static void printContainer(int[] singleContainer) {
		for (int j = 0; j < singleContainer.length; j++) {
			System.out.print(singleContainer[j]);
			if (j < singleContainer.length - 1) {
				System.out.print(",");
			}
		}
	}
}
