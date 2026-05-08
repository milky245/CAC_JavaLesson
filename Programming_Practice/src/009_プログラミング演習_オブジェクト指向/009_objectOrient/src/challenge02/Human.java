//challenge02（クラス変数とクラスメソッド）
//提供されているクラスを、下記に従って改造してください
//1,Humanクラスに「社員番号」を追加します
//	社員番号は、Humanクラスのインスタンスを生成するたびに＋１される番号とします
//2,Humanクラスに「部署名（営業、総務、開発）」と「部署番号」を追加します
//	部署名はString[]型とします
//	コンストラクタで部署番号を設定するように修正してください
//3,Humanクラスに「部署番号を入力すると部署名を返すメソッド」を追加してください
//	クラスメソッドとします
//4,Humanクラスに「自分が所属する部署名を返すメソッド」を追加してください
//	インスタンスメソッドとします
//5,自己紹介に自分の社員番号を含めるように修正してください
//6,3,4のメソッドを使って部署名を出力してください
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
	/** 社員番号 */
	private static int employeeCounter = 0;
	/** 部署名 */
	private static final String[] departNames = {"営業", "総務", "開発"};
	/** 部署番号 */
	private int departNumber;

	/**
	 * 引数なしのコンストラクタ
	 */
	public Human() {
		++Human.employeeCounter;
	}

	/**
	 * 引数がnameのみのコンストラクタ
	 * @param name
	 */
	public Human(String name) {
		++Human.employeeCounter;
		this.name = name;
	}

	/**
	 *  すべてのフィールドを設定するコンストラクタ
	 * @param name
	 * @param gender
	 * @param age
	 * @param day
	 */
	public Human(String name, String gender, int age, Day day, int departNumber) {
		++Human.employeeCounter;
		this(name);
		this.gender = gender;
		this.age = age;
		this.birthday = new Day(day);
		this.departNumber = departNumber;
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
        return "名前は" + name + "です。" + "性別は" + gender + "です。" + "年齢は" + age + "歳です。\n"
                + "誕生日は" + birthday + "です。" + "社員番号は" + employeeCounter + "です。" + "部署は" + getDepartName(departNumber) + "です。";

	}

    public String[] getDepartNames() {
        return departNames;
    }

    public int getDepartNumber() {
		return departNumber;
	}

	public void setDepartNumber(int departNumber) {
		this.departNumber = departNumber;
	}

	public String getDepartName(int departNumber) {
//		String[] departNames = {"営業", "総務", "開発"};
		if (departNumber < 1 || departNumber > Human.departNames.length) {
			return "不正な部署番号です。";
		}
		return Human.departNames[departNumber - 1];
	}
}
