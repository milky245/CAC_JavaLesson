/**
 * 配列要素のシャッフル
 *
 * 配列要素の中身がランダムな順番になるようにかき混ぜる（シャッフルする）
 * プログラムを作成してください。
 *
 * Randomクラスが数値のランダムに関する機能を持っています。
 * Random random = new Random();
 * int num = 10;
 * int i = random.nextInt(num); // 0～9までの値をランダムに1つ代入する
 *
 * 実行例：
 *
 * シャッフル前：
 * 1 2 3 4 5 6 7 8 9 10
 * シャッフル後：
 * 3 8 4 7 10 6 1 5 9 2
 *
 */

package section04_summary.challenge02;


public class ArrayShuffle {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		System.out.println("シャッフル前：");
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();

		shuffleArr(array);

		System.out.println("シャッフル後：");
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();

	}

	public static void shuffleArr(int[] arr) {
		java.util.Random random = new java.util.Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1); // 0～iまでの値をランダムに1つ代入する
			// arr[i]とarr[j]を交換する
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
