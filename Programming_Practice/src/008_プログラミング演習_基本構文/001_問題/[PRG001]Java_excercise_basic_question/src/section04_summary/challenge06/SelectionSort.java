/**
 * 選択ソート
 * 入力された数字10個を降順に並べ替えるプログラムを作成してください。
 *
 * ソートアルゴリズムには様々な種類がありますが、今回は選択ソートを使用します。
 *
 * まず、並べ替える数字の入っている箱が横一列に並んでいるとイメージします。
 * 最初は1個めの数字と他の箱を比較し、一番大きい箱（MAX値）を選択します。MAX値と一番左（1個めの箱）の値を交換します。
 * 次は2個め～最後までの箱を比較し、MAX値を調べ、MAX値を2個目の箱に移動します。
 * これをすべての箱について繰り返せば、最終的に左から順に大きな数字に並べ替えることができます。
 * このように、数値の中から一番大きい(あるいは小さい)値を選択して並べ替えていくソートアルゴリズムを、選択ソートと読んでいます。
 *
 * 参考：https://gigazine.net/news/20140501-sorting/
 *
 * 実行例：
 *
 * ソート前：
 * 7 90 23 77 97 37 32 45 55 76
 * ソート後：
 * 97 90 77 76 55 45 37 32 23 7
 *
 */
package section04_summary.challenge06;

public class SelectionSort {

	public static void selectionSort(int[] array) {
		//selection sort
		for (int i = 0; i < array.length - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			//swap array[i] and array[maxIndex]
			int temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
		}
	}

	public static void main(String[] args) {
		//selection Sort example
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println("ソート前：");
		for (int j : array) {
			System.out.print(j + " ");
		}
		System.out.println();
		selectionSort(array);
		System.out.println("ソート後：");
		for (int j : array) {
			System.out.print(j + " ");
		}
		System.out.println();


	}

}
