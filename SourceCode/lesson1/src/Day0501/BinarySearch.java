package Day0501;

public class BinarySearch {
	/**
	 * 2分探索法（※配列は昇順にソートされている必要があります）
	 */
	public static int doSearch(int[] array, int target) {
		int left = 0; // 探索範囲の左端
		int right = array.length - 1; // 探索範囲の右端

		// 探索範囲がなくなる（左端が右端を追い越す）まで繰り返す
		while (left <= right) {
			int mid = (left + right) / 2; // 中央のインデックスを計算

			if (array[mid] == target) {
				return mid; // 中央の値と一致したら見つかったので返す
			} else if (array[mid] < target) {
				// 探したい値の方が大きい場合、右半分を新たな探索範囲にする
				left = mid + 1;
			} else {
				// 探したい値の方が小さい場合、左半分を新たな探索範囲にする
				right = mid - 1;
			}
		}

		return -1; // 探索範囲がなくなったら「見つからなかった」
	}
}
