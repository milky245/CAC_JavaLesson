package q01_basic.question07;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数リストを制御するクラス
 * 1 NumberList クラス：addFromOneTo メソッド内で、1 から引数で取得した整数までの数値を順番に List 型の numbers フィ
 * ールドに追加する。
 * 2 NumberList クラス：calcSumOfList メソッド内で、numbers フィールドの各要素の合計値を計算し、戻り値として計算結果
 * を返す。
 * 3 NumberList クラス：doubleListEachValue メソッド内で、numbers フィールドの各要素を 2 倍にする。
 * 4 NumberList クラス：removeIndexOfFirstHalf メソッド内で、numbers フィールドの要素の前半部分を削除する。なお、要素
 * 数が奇数の場合、中央値は残すこと。
 */
class NumberList {

	/**
	 * 整数のList
	 * 
	 */
	private List<Integer> numbers = new ArrayList<>();

	/**
	 * 1から引数までの整数をListに代入する
	 * 
	 * @param limit（Listの最終要素）
	 */
	public void addFromOneTo(Integer limit) {
		//TODO ここから実装する
		for (int i = 1; i <= limit; i++) {
			numbers.add(i);
		}
	}

	/**
	 * Listの各要素整数を合計する
	 * 
	 * @return Listの要素の合計値
	 */
	public Integer calcSumOfList() {
		Integer sum = 0;
		//TODO ここから実装する
		for (Integer number : numbers) {
			sum += number;
		}

		return sum;
	}

	/**
	 * Listの各要素を2倍にする
	 * 
	 */
	public void doubleListEachValue() {
		//TODO ここから実装する
        numbers.replaceAll(integer -> integer * 2);
	}

	/**
	 * Listの要素の前半部分を削除する
	 * 要素数が奇数の場合、中央値は残す
	 */
	public void removeIndexOfFirstHalf() {
		//TODO ここから実装する
		//int size = numbers.size();
		int halfSize = (numbers.size()) / 2;
		numbers.subList(0, halfSize).clear();
	}

	/**
	 * @return numbers
	 */
	public List<Integer> getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers セットする numbers
	 */
	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

}
