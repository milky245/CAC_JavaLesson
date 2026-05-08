/**
 * クラスの成績
 *
 * 実行例を参考に、クラス毎の成績を計算して一覧を出力してください
 *
 * クラス数と各クラスの人数を入力させ、人数分の点数を入力し、成績を計算します
 * 合計点は整数、平均点は有効数字1桁の実数で表示してください
 *
 * ※標準出力の桁数を制御するにはSystem.out.printfまたはString.formatを使用します
 * 　調べてもよくわからない場合は、桁数を揃えずに出力してください
 *クラス数＞2
 *
 * 1組目の人数＞3
 * 1組1番の点数＞50
 * 1組2番の点数＞63
 * 1組3番の点数＞72
 *
 * 2組目の人数＞2
 * 2組1番の点数＞79
 * 2組2番の点数＞43
 *
 *   組 |   合計   平均
 * ---------------------
 *  1組 |    185   61.7
 *  2組 |    122   61.0
 * ---------------------
 *   計 |    307   61.4
 */
package section04_summary.challenge07;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeList {

	public static void printGradeList(ArrayList<ArrayList<Integer>> grades) {
		System.out.println("  組 |   合計   平均");
		System.out.println("---------------------");
		int totalSum = 0;
		int totalCount = 0;
		for (int i = 0; i < grades.size(); i++) {
			ArrayList<Integer> classGrades = grades.get(i);
			int sum = 0;
			for (int grade : classGrades) {
				sum += grade;
			}
			double average = (double) sum / classGrades.size();
			System.out.printf("%3d組 | %7d %6.1f\n", i + 1, sum, average);
			totalSum += sum;
			totalCount += classGrades.size();
		}
		System.out.println("---------------------");
		double totalAverage = (double) totalSum / totalCount;
		System.out.printf("  計 | %7d %6.1f\n", totalSum, totalAverage);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("クラス数＞");
		int classNum = scanner.nextInt();
		System.out.println();

		ArrayList<ArrayList<Integer>> grades = new ArrayList<>();
		for (int i = 0; i < classNum; i++) {
			System.out.printf("%d組目の人数＞", i + 1);
			int studentNum = scanner.nextInt();
			System.out.println();

			ArrayList<Integer> classGrades = new ArrayList<>();
			for (int j = 0; j < studentNum; j++) {
				System.out.printf("%d組%d番の点数＞", i + 1, j + 1);
				int grade = scanner.nextInt();
				classGrades.add(grade);
			}
			System.out.println();
			grades.add(classGrades);
		}
		printGradeList(grades);




	}

}
