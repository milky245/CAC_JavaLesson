package challenge03;

import java.util.Random;

public class Gladiator extends Human {

	/** ヒットポイント */
	private int hp;
	/** 装備している武器 */
	private Weapon eqW;
	/** 装備している防具 */
	private Protect eqP;

	// 正しいコンストラクタへ修正してください
	public Gladiator(String WeaponName, int offensive, String protectName, int defensive) {
		this.hp = 100;
		this.eqW = new Weapon(WeaponName, offensive);
		this.eqP = new Protect(protectName, defensive);
	}

	/*
	 * ゲッタ/セッタは使わない想定なので省略
	 */

	/**
	 * @return hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * 攻撃力を取得するメソッド
	 * 
	 * @return
	 */
	public int attack() {
		return eqW.getOffensive();
	}

	/**
	 * 防御に成功したとき、ダメージを軽減するメソッド
	 * 
	 * @param offensive
	 */
	public void defence(int offensive) {
		int damage = offensive - eqP.getDefensive();
		damage(damage);
	}

	/**
	 * ダメージを受けて、HPを減らすメソッド
	 * 
	 * @param damage
	 */
	public void damage(int damage) {
		hp -= damage;
	}

	/**
	 * 攻撃を行うかをランダムに決定
	 * 
	 * @return
	 */
	public boolean canAttack() {
		return new Random().nextInt(2) > 0 ? true : false;
	}

	/**
	 * 防御を行うかをランダムに決定
	 * 
	 * @return
	 */
	public boolean canDefence() {
		return new Random().nextInt(2) > 0 ? true : false;
	}
}
