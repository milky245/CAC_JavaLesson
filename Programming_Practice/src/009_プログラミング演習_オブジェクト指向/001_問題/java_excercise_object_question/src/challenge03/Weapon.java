package challenge03;

public class Weapon {

	/** 武器の名前 */
	private String name;
	/** 攻撃力 */
	private int offensive;

	public Weapon(String name, int offensive) {
		this.name = name;
		this.offensive = offensive;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return offensive
	 */
	public int getOffensive() {
		return offensive;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param offensive
	 *            セットする offensive
	 */
	public void setOffensive(int offensive) {
		this.offensive = offensive;
	}
}
