/**
 * 券売機
 * 
 * 牛丼屋の券売機を作成したい
 * この券売機は以下の流れで引換券を発券する
 * ０．Enterを押す（タッチパネル券売機で最初にタッチするイメージ）
 * １．商品を選ぶ(3つまで)※1
 * ２．商品の合計金額以上を投入（入力）する
 * ３．おつりを計算する
 * ４．選ばれた商品それぞれの引換券（シリアルナンバー付き※2）を発券する
 * ５．おつりを返却する※3
 * ６．１に戻る
 * ※1：商品は番号で選択する
 * ※1：商品番号が存在しない場合は選びなおさせる
 * ※2：シリアルナンバーは券売機が動作してから共通で採番される連番(seqNo)である
 * ※2：引換券は「商品名[seqNo]」の形式とする
 * ※3：お釣りが1円以上ある場合のみ返却する
 * 
 * 上記の動作を実現するプログラムを作成せよ
 * 
 * 動作例）
 * ご利用の方はEnterを押してください(何か入力してenter)＞a
 * 
 * いらっしゃいませ！当店の商品はこちらです！
 * 1．牛丼（並）　　　：380円
 * 2．牛丼（大盛）　　：530円
 * 3．ネギたっぷり牛丼：490円
 * 4．チキンカレー　　：590円
 * 5．お肉満腹定食　　：980円
 * 9．終了
 * 
 * 1つ目の商品をお選びください(3つまで)＞1
 * 2つ目の商品をお選びください(3つまで)＞10
 * ※その商品は現在お取り扱いがございません※
 * 2つ目の商品をお選びください(3つまで)＞4
 * 3つ目の商品をお選びください(3つまで)＞9
 * ありがとうございます。
 * 
 * 料金は920円です。
 * 料金を投入してください＞1000
 * 
 * 引換券を発券いたします：
 * 牛丼（並）[1], チキンカレー[2]
 * 
 * //お釣りがある場合
 * おつりを返却いたします：
 * 20円
 * 
 * ご利用ありがとうございました
 * 
 * いらっしゃいませ！当店の商品はこちらです！
 * ...（以下、動作を止めるまで続行）
 * 
 * ----商品が選ばれなかった場合-----
 * 1つ目の商品をお選びください(3つまで)＞9
 * 
 * ご利用ありがとうございました
 * 
 * いらっしゃいませ！当店の商品はこちらです！
 * ...（以下、動作を止めるまで続行）
 * 
 */

package section04_summary.challenge01;

import java.util.*;
import section04_summary.challenge01.Product;
import section04_summary.challenge01.Ticket;

public class VendingMachine {

	private Map<Integer, Product> menu = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	public VendingMachine() {
		// 商品の初期化
		menu.put(1, new Product(1, "牛丼（並）", 380));
		menu.put(2, new Product(2, "牛丼（大盛）", 530));
		menu.put(3, new Product(3, "ネギたっぷり牛丼", 490));
		menu.put(4, new Product(4, "チキンカレー", 590));
		menu.put(5, new Product(5, "お肉満腹定食", 980));
	}

	public void start() {
		while (true) {
			System.out.println("ご利用の方はEnterを押してください(何か入力してenter)＞");
			sc.nextLine(); // Enterを待つ

			List<Product> selected = selectProducts();
			if (selected.isEmpty()) {
				System.out.println("ご利用ありがとうございました");
				continue;
			}

			int total = calculateTotal(selected);
			int payment = inputMoney(total);

			List<Ticket> tickets = issueTickets(selected);
			printTickets(tickets);

			int change = payment - total;
			if (change > 0) {
				System.out.println("おつりを返却いたします：");
				System.out.println(change + "円");
			}

			System.out.println("ご利用ありがとうございました");
		}
	}

	private List<Product> selectProducts() {
		List<Product> selected = new ArrayList<>();
		showMenu();

		for (int i = 1; i <= 3; i++) {
			System.out.println(i + "つ目の商品をお選びください(3つまで)＞");
			int choice = Integer.parseInt(sc.nextLine());

			if (choice == 9) break;

			if (!menu.containsKey(choice)) {
				System.out.println("※その商品は現在お取り扱いがございません※");
				i--; // 選びなおさせる
				continue;
			}
			selected.add(menu.get(choice));
		}
		System.out.println("ありがとうございます。");
		return selected;
	}

	private void showMenu(){
		System.out.println("いらっしゃいませ！当店の商品はこちらです！");
		for (Product p : menu.values()) {
			System.out.println(p.getId() + "．" + p.getName() + "　　　：" + p.getPrice() + "円");
		}
		System.out.println("9．終了");
	}

	private int calculateTotal(List<Product> selected) {
		int total = 0;
		for (Product p : selected) {
			total += p.getPrice();
		}
		System.out.println("料金は" + total + "円です。");
		return total;
	}

	private int inputMoney(int total) {
		while (true){
			System.out.println("料金を投入してください＞");
			int payment = Integer.parseInt(sc.nextLine());
			if (payment >= total) {
				return payment;
			}
			System.out.println("金額が不足しています。再度投入してください。");
		}
	}

	private List<Ticket> issueTickets(List<Product> selected) {
		List<Ticket> tickets = new ArrayList<>();
		for (Product p : selected) {
			tickets.add(new Ticket(p.getName()));
		}
		return tickets;
	}

	private void printTickets(List<Ticket> tickets) {
		System.out.println("引換券を発券いたします：");
		for (int i = 0; i < tickets.size(); i++) {
			System.out.print(tickets.get(i));
			if (i < tickets.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
}
