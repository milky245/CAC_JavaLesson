package challenge04.character;

/**
 * 戦闘に関するインターフェイス<br>
 * コマンドはジャンケン形式になっており、攻撃→スペシャル→魔法→攻撃の三竦となる
 * 
 * @author k-mori
 *
 */
public interface IBattleOperation {
	/** コマンドの表示用配列 */
	String[] COMMAND_DISP = { "1:攻撃", "2:魔法", "3:スペシャル" };
	/** 攻撃を行うコマンド パー */
	int COMM_ATTACK = 1;
	/** 魔法攻撃を行うコマンド チョキ */
	int COMM_MAGIC = 2;
	/** スペシャル攻撃を行うコマンド グー */
	int COMM_SPECIAL = 3;

	/**
	 * 攻撃を行うメソッド
	 * 
	 * @return offensive
	 */
	int getOffensive();

	/**
	 * HPを取得するメソッド
	 * 
	 */
	int getHp();

	/**
	 * ダメージ計算を行うメソッド
	 * 
	 * @param damage
	 */
	void damage(int damage);

	/**
	 * コマンドを入力して行動を決定するメソッド
	 * 
	 * @param command
	 */
	int chooseCommand();

	String getName();
	String getGender();
	int getAge();
}
