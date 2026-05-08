package Day0501;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] numbers = { 25, 36, 3, 99, 22, 77 };
		int target = 100;//探索する値
		Integer index = null;//targetがある配列の要素番号

		//線形探索
//		index = LinearSearch.doSearch(numbers, target);
//
//		//番兵法
/*//		//		index = SentinelSearch.doSearch(numbers, target);
//
//		if (index == -1) {
//			System.out.println("探索結果が見つかりませんでした。");
//		} else {
//			System.out.println("探索結果が見つかりました：numbers[" + index + "]");
//		}*/

		// ※2分探索を使うには、必ず事前に配列がソートされている必要があります
		System.out.println("配列を昇順にします");
		Arrays.sort(numbers);//[3, 22, 25, 36, 77, 99]
		System.out.println(Arrays.toString(numbers));

		//作成した2分探索
		index = BinarySearch.doSearch(numbers, target);
		// 標準ライブラリの2分探索：Arrays.binarySearch を呼び出すだけ
		//		index = Arrays.binarySearch(numbers, target);

		if (index == -1) {
			System.out.println("探索結果が見つかりませんでした。");
		} else {
			System.out.println("探索結果が見つかりました：numbers[" + index + "]");
		}

	}

}
