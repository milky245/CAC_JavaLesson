package challenge04;

import challenge04.character.ComputerGladiator;
import challenge04.character.IBattleOperation;
import challenge04.character.PlayerGladiator;

/**
 * 決闘を進行するクラス <br>
 * このクラス内に各種メソッドを組み合わせて結果までを出力する処理を記述する
 * 
 * @author
 *
 * 2,提供されたクラスのメソッドを組み合わせて、Colosseum.java内に下記を実現する処理を
 * 　記述してください
 * 	ジャンケン形式でPlayerとComputerを戦わせます（IBattleOperationにルールを記載しています）
 * 	Playerはコマンドを手入力し、Computerはランダムに決定すること
 * 	ジャンケンに負けたほうのHPを、勝った方の攻撃力分減らします
 * 	HPが先に0以下になった側を負けとします
 * 	勝った方に自己紹介をさせてください
 * 3,実行例を下記に示します
 * 　行動選択→攻撃判定→残りHP表示を繰り返し、最後に自己紹介を出力してください
 *
 * ※duellingメソッドで最初に作成している配列を必ず使ってください。
 * ※提供済みのクラスとメソッドで実現できますが、Colosseumクラス以外の場所に必要なメソッドがあれば追加しても構いません。
 * 　ただし、抽象クラスとインターフェイスは修正しないでください。
 *
 *
 * -------------
 * 実行例
 * -------------
 * 尋常に勝負！
 *
 * 行動を選択してください
 * 1:攻撃 2:魔法 3:スペシャル ＞2
 * クロウの攻撃がHIT！
 * 　クロウ:HP 100
 * 　フェニックス:HP 70
 *
 * 行動を選択してください
 * 1:攻撃 2:魔法 3:スペシャル ＞1
 * 両者ともに動くことができない！
 * 　クロウ:HP 100
 * 　フェニックス:HP 70
 *
 * 行動を選択してください
 * 1:攻撃 2:魔法 3:スペシャル ＞2
 * クロウの攻撃がHIT！
 * 　クロウ:HP 100
 * 　フェニックス:HP 40
 *
 * 行動を選択してください
 * 1:攻撃 2:魔法 3:スペシャル ＞1
 * 両者ともに動くことができない！
 * 　クロウ:HP 100
 * 　フェニックス:HP 40
 *
 * 行動を選択してください
 * 1:攻撃 2:魔法 3:スペシャル ＞2
 * クロウの攻撃がHIT！
 * 　クロウ:HP 100
 * 　フェニックス:HP 10
 *
 * 行動を選択してください
 * 1:攻撃 2:魔法 3:スペシャル ＞1
 * クロウの攻撃がHIT！
 * 　クロウ:HP 100
 * 　フェニックス:HP -20
 *
 * 勝負あり！！
 * 勝者の自己紹介タイム！
 * 名前はクロウです。性別は男です。年齢は43歳です。
 *
 */
public class Colosseum {
	/**
	 * 決闘を進行するメソッド
	 */
	public void duelling() {
		// キャラクターをインスタンス化
		IBattleOperation[] duelist = { new PlayerGladiator("クロウ", "男", 43, 25),
				new ComputerGladiator("フェニックス", "男", 38, 20) };
		// ここに処理を記述
		// 進行に必要なメソッドがあれば適宜追加する
		System.out.println("尋常に勝負！");
		// ジャンケンの勝敗を判定
		do{
			//System.out.println("行動を選択してください");
			//System.out.print("1:攻撃 2:魔法 3:スペシャル ＞");
			int playerCommand = duelist[0].chooseCommand();
			int computerCommand = duelist[1].chooseCommand();

			if (playerCommand == computerCommand) {
				System.out.println("両者ともに動くことができない！");
			} else if ((playerCommand - computerCommand + 3) % 3 == 1) {
				System.out.println(duelist[0].getName() + "の" + duelist[0].getOffensive() + "の攻撃がHIT！");
				duelist[1].damage(duelist[0].getOffensive());
			} else {
				System.out.println(duelist[1].getName() + "の" + duelist[1].getOffensive() + "の攻撃がHIT！");
				duelist[0].damage(duelist[1].getOffensive());
			}
			System.out.println("　" + duelist[0].getName() + ":HP " + duelist[0].getHp());
			System.out.println("　" + duelist[1].getName() + ":HP " + duelist[1].getHp());

			if (duelist[0].getHp() <= 0 || duelist[1].getHp() <= 0) {
				break;
			}
		} while (duelist[0].getHp() > 0 && duelist[1].getHp() > 0);

		System.out.println("\n勝負あり！！");
		System.out.println("勝者の自己紹介タイム！");
		if (duelist[0].getHp() > 0) {
			System.out.println("名前は"+duelist[0].getName()+"です。性別は"+duelist[0].getGender()+"です。年齢は"+duelist[0].getAge()+"歳です。");
		} else {
			System.out.println("名前は"+duelist[1].getName()+"です。性別は"+duelist[1].getGender()+"です。年齢は"+duelist[1].getAge()+"歳です。");
		}
	}
}
