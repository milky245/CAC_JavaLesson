package challenge02;

public class Human {
	/** 名前 */
	private String name;
	/** 性別 */
	private String gender;
	/** 年齢 */
	private int age;
	/** 誕生日 */
	private Day birthday;

	/**
	 * 引数なしのコンストラクタ
	 */
	public Human() {
	}

	/**
	 * 引数がnameのみのコンストラクタ
	 * @param name
	 */
	public Human(String name) {
		this.name = name;
	}

	/**
	 *  すべてのフィールドを設定するコンストラクタ
	 * @param name
	 * @param gender
	 * @param age
	 * @param day
	 */
	public Human(String name, String gender, int age, Day day) {
		this(name);
		this.gender = gender;
		this.age = age;
		this.birthday = new Day(day);
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
	 * @return birthday
	 */
	public Day getBirthday() {
		return birthday;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param gender セットする gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param age セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(Day birthday) {
		this.birthday = birthday;
	}

	/**
	 * 自己紹介を出力する
	 */
	public String toString() {
		String str = "名前は" + name + "です。" + "性別は" + gender + "です。" + "年齢は" + age + "歳です。\n" + "誕生日は" + birthday + "です。";
		return str;

	}
}
