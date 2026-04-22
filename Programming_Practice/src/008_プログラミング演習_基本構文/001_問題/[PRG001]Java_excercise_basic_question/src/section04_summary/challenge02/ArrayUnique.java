/**
 * 重複なしの配列
 * 
 * Random.nextInt(int)を使って配列にランダムな値を代入します。
 * ただし、配列中の値が重複しない（ユニーク）となるように代入してください。
 * 
 * 実行例：
 * 数字を読み上げます：
 * 10 5 2 1 9 4 7 8 6 3
 *  
 */

package section04_summary.challenge02;

public class ArrayUnique {

	public static void main(String[] args) {
		int[] array = new int[10];
		java.util.Random random = new java.util.Random();

		for (int i = 0; i < array.length; i++) {
			int num;
			do {
				num = random.nextInt(10) + 1; // 1～10までの値をランダムに1つ代入する
			} while (containsNum(array, num)); // 配列にnumがすでに含まれている場合は再度生成する
			array[i] = num;
		}

		System.out.println("数字を読み上げます：");
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static boolean containsNum(int[] arr, int num) {
		for (int n : arr) {
			if (n == num) {
				return true;
			}
		}
		return false;
	}

}
