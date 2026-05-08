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
 */
public class Colosseum {
	/**
	 * 決闘を進行するメソッド
	 */
	public void duelling() {
		// キャラクターをインスタンス化
		IBattleOperation[] duelist = { new PlayerGladiator("クロウ", "男", 43, 30),
				new ComputerGladiator("フェニックス", "男", 38, 40) };
		// ここに処理を記述
		// 進行に必要なメソッドがあれば適宜追加する
	}
}
