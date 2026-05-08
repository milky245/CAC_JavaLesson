package challenge04.character;

import java.util.Random;

/**
 * コンピューターが操作する剣闘士クラス
 * 
 * @author k-mori
 *
 */
public class ComputerGladiator extends AbstractHuman implements IBattleOperation {

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
	public ComputerGladiator(String name, String gender, int age, int offensive) {
		super(name, gender, age);
		this.hp = 100;
		this.offensive = offensive;
	}

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
	@Override
	public int chooseCommand() {
		return new Random().nextInt(IBattleOperation.COMMAND_DISP.length) + 1;
	}
}