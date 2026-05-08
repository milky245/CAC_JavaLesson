package challenge03;

public class Protect {

	/** 防具の名前 */
	private String name;
	/** 防御力 */
	private int defensive;

	public Protect(String name, int defensive) {
		this.name = name;
		this.defensive = defensive;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return defensive
	 */
	public int getDefensive() {
		return defensive;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param defensive
	 *            セットする defensive
	 */
	public void setDefensive(int defensive) {
		this.defensive = defensive;
	}

}
