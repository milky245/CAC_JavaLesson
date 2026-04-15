/**
 * 第4章 倉庫番のお仕事
 *
 * 問題8 荷物の入れ替え（二つの配列の要素を入れ替える）
 *
 * AB興産から新たな荷物のセットを預かりました。
 * 5袋からなる荷物のセットで、それぞれ6～10の数値が入っており、
 * どの袋にどの数値が入っているのかはランダムに決定し、
 * それぞれの袋の値は重複しません。
 *
 * AB興産からの依頼は、以前から預かっている1～5の荷物と
 * 今回預かる6～10の荷物を再編し、奇数のみの配列と
 * 偶数のみの配列に分けるというものです。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  AB興産から新たに預かった荷物と以前から預かっている荷物の
 *  中身を確認してください。
 *
 *  Yさん：
 *  はい、
 *  以前から預かっている荷物の状態は、
 *  3,2,1,5,4
 *  です。
 *
 *  今回預かった荷物の状態は、
 *  7,9,10,6,8
 *  です。
 *
 *  E主任：
 *  その二つの荷物を奇数群、偶数群で入れ替えてください。
 *
 *  Yさん：
 *  はい、入れ替えました。
 *  奇数群の荷物の状態は、
 *  3,5,1,9,7
 *  です。
 *
 *  偶数群の荷物の状態は、
 *  10,2,8,6,4
 *  です。
 *
 */

package lesson04.challenge08;

public class WarehouseManager {

	public static void main(String[] args) {

		int[] ABKosanArray1 = new int[5];
		int[] ABKosanArray2 = new int[5];


		//ここに重複チェックおよび値の代入処理を記述する①(1～5)
		//シャッフル　1-5
		for (int i = 0; i < ABKosanArray1.length; i++) {
			ABKosanArray1[i] = i + 1;
		}
		shuffleArray(ABKosanArray1);


		//ここに重複チェックおよび値の代入処理を記述する②(6～10)
		//シャッフル　6-10
		for (int i = 0; i < ABKosanArray2.length; i++) {
			ABKosanArray2[i] = i + 6;
		}

		shuffleArray(ABKosanArray2);


		System.out.println("E主任：");
		System.out.println("AB興産から新たに預かった荷物と以前から預かっている荷物の");
		System.out.println("中身を確認してください。\n");

		System.out.println("Yさん：");
		System.out.println("はい、");
		System.out.println("以前から預かっている荷物の状態は、");
		for (int i = 0; i < ABKosanArray1.length; i++) {
			System.out.print(ABKosanArray1[i]);
			if (i != (ABKosanArray1.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("今回預かった荷物の状態は、");
		for (int i = 0; i < ABKosanArray2.length; i++) {
			System.out.print(ABKosanArray2[i]);
			if (i != (ABKosanArray2.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("E主任：");
		System.out.println("その二つの荷物を奇数群、偶数群で入れ替えてください。\n");



		//ここに奇数群(ABKosanArray1)と偶数群(ABKosanArray2)に振り分ける処理を記述する。
			int oddIndex = 0;
			int evenIndex = 0;
			separateOddEven(ABKosanArray1, ABKosanArray2);


		System.out.println("Yさん：");
		System.out.println("はい、入れ替えました。");
		System.out.println("奇数群の荷物の状態は、");
		for (int i = 0; i < ABKosanArray1.length; i++) {
			System.out.print(ABKosanArray1[i]);
			if (i != (ABKosanArray1.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("偶数群の荷物の状態は、");
		System.out.println("");
		for (int i = 0; i < ABKosanArray2.length; i++) {
			System.out.print(ABKosanArray2[i]);
			if (i != (ABKosanArray2.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。");

	}

	public static void shuffleArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int randomIndex = (int) (Math.random() * array.length);
			int temp = array[i];
			array[i] = array[randomIndex];
			array[randomIndex] = temp;
		}

	}
	private static void separateOddEven(int[] array1, int[] array2) {
		int oddIndex = 0;
		int evenIndex = 0;
		int[] tempOdd = new int[5];
		int[] tempEven = new int[5];

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] % 2 != 0) {
				tempOdd[oddIndex] = array1[i];
				oddIndex++;
			} else {
				tempEven[evenIndex] = array1[i];
				evenIndex++;
			}
		}

		for (int i = 0; i < array2.length; i++) {
			if (array2[i] % 2 != 0) {
				tempOdd[oddIndex] = array2[i];
				oddIndex++;
			} else {
				tempEven[evenIndex] = array2[i];
				evenIndex++;
			}
		}

		System.arraycopy(tempOdd, 0, array1, 0, 5);
		System.arraycopy(tempEven, 0, array2, 0, 5);
	}
}
