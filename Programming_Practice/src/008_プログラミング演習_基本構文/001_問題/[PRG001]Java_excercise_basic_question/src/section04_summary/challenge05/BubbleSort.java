/**
 * バブルソート
 * 入力された数字10個を昇順に並べ替えるプログラムを作成してください。
 *
 * ソートアルゴリズムには様々な種類がありますが、今回はバブルソートを使用します。
 *
 * まず、並べ替える数字の入っている箱が横一列に並んでいるとイメージします。
 * 左から1個目の箱と2個目の箱を比較し、2個目のほうが小さいなら数字を交換します。（大きい数字を右に移動）
 * 次は2個目の箱と3個目の箱を比較し、3個目のほうが小さいなら数字を交換します。（大きい数字を右に移動）
 * この比較を順番にすべての箱（数字）で行っていきます。
 * すると、1回目の繰り返しでは一番右の箱には一番大きい数字が格納されます。
 * 1個目の箱（一番右の箱）が終わったら、その箱を除く箱を再度左から順番に比較していきます。
 * 最終的に左から順に小さい数字（右から順に大きい数字）になるように並べ替えます。
 * このように、隣接している要素同士を比較して並び替えを行うソートアルゴリズムを、バブルソート呼びます。
 *
 * 実行例：
 *
 * ソート前：
 * 15 63 50 1 4 68 100 3 42 7
 * ソート後：
 * 1 3 4 7 15 42 50 63 68 100
 *
 */
package section04_summary.challenge05;

public class BubbleSort {

	//method
	public static void bubbleSort(int[] array) {
		//bubble sort
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					//swap array[j] and array[j + 1]
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {


		//generate 10 random numbers between 1 and 100
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100) + 1;
		}
		//print the array before sorting
		System.out.println("ソート前：");
        for (int j : array) {
            System.out.print(j + " ");
        }
		System.out.println();
		bubbleSort(array);


		//print the array after sorting
		System.out.println("ソート後：");
		for (int j : array) {
			System.out.print(j + " ");
		}
		System.out.println();

	}

}
