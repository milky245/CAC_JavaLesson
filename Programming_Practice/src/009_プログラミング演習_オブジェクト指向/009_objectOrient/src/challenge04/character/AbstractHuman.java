package challenge04.character;

/**
 * 人間抽象クラス 人についての性質と機能をまとめたクラス
 * 
 * @author k-mori
 *
 */
public abstract class AbstractHuman {
	/** 名前 */
	private String name;
	/** 性別 */
	private String gender;
	/** 年齢 */
	private int age;

	/**
	 * すべてのフィールドを設定するコンストラクタ
	 * 
	 * @param name
	 * @param gender
	 * @param age
	 */
	public AbstractHuman(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param gender
	 *            セットする gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param age
	 *            セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 自己紹介を出力する
	 */
	public String toString() {
		String str = "名前は" + name + "です。" + "性別は" + gender + "です。" + "年齢は" + age + "歳です。";
		return str;
	}
}
