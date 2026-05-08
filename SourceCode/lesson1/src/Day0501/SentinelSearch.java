package Day0501;

public class SentinelSearch {
	/**
	 * 番兵法を用いた線形探索
	 */
	public static int doSearch(int[] array, int target) {
		int n = array.length;

		// 番兵を置くために、元の配列より1つ大きい配列を用意する
		int[] workArray = new int[n + 1];
		System.arraycopy(array, 0, workArray, 0, n); // データをコピー

		// 配列の最後に「番兵」として探したい値をセット
		workArray[n] = target;

		int i = 0;
		// 「データが見つかる」までひたすら進む（終了条件が1つで済む！）
		while (workArray[i] != target) {
			i++;
		}

		// 見つかった場所が番兵の位置（n）なら、元々の配列には存在しなかったということ
		if (i == n) {
			return -1;
		} else {
			return i; // 元の配列の中で見つかった場合
		}
	}
}
