package Day0501;

public class LinearSearch {
	/**
	 * 線形探索法
	 * @param array 探索対象の配列
	 * @param target 探したい値
	 * @return 見つかった場合はそのインデックス、見つからない場合は -1
	 */
	public static int doSearch(int[] array, int target) {
		// 配列の先頭から末尾まで順番に調べる
		for (int i = 0; i < array.length; i++) {
			// データが見つかったら、その場所（インデックス）を返す
			if (array[i] == target) {
				return i;
			}
		}
		// 最後まで探しても見つからなかった場合
		return -1;
	}
}
