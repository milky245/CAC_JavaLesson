package challenge04.character;

import java.util.Scanner;

/**
 * プレイヤーが操作する剣闘士クラス
 * 
 * @author k-mori
 *
 */
public class PlayerGladiator extends AbstractHuman implements IBattleOperation {

	/** ヒットポイント */
	private int hp;
	/** 攻撃力 */
	private int offensive;

	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param gender
	 * @param age
	 * @param offensive
	 */
	public PlayerGladiator(String name, String gender, int age, int offensive) {
		super(name, gender, age);
		this.hp = 100;
		this.offensive = offensive;
	}

//	public String getName() {
//		return super.getName();
//	}
	/*
	 * (非 Javadoc)
	 * 
	 * @see challenge04.character.IBattleOperation#getOffensive()
	 */
	@Override
	public int getOffensive() {
		return offensive;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see challenge04.character.IBattleOperation#getHp()
	 */
	@Override
	public int getHp() {
		return hp;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see challenge04.character.IBattleOperation#damage(int)
	 */
	@Override
	public void damage(int damage) {
		hp -= damage;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see challenge04.character.IBattleOperation#choseCommand()
	 */
	@SuppressWarnings("resource")
	@Override
	public int chooseCommand() {
		Scanner stdIn = new Scanner(System.in);
		int ret = 0;
		do {
			System.out.println("行動を選択してください");
			for (String str : IBattleOperation.COMMAND_DISP) {
				System.out.print(str + " ");
			}
			System.out.print("＞");
			ret = stdIn.nextInt();
		} while (ret < IBattleOperation.COMM_ATTACK || ret > IBattleOperation.COMM_SPECIAL);
		return ret;
	}
}
