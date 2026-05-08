package q01_basic.question04;
/**
 * 会員クラス
 * 会員の名前、年齢、ランクをフィールドとして持ち、会員の情報を表示するメソッドを持つ。
 */
class Member {
    //TODO ここから実装する
    private int id; // 会員ID
    private String password; // パスワード
    private String name; // 会員の名前
    private int age; // 会員の年齢
    private int rank; // 会員のランク

    /**
     * 会員の情報を初期化する
     */
    public Member() {
        this.password = null;
        this.name = null;
        this.age = 0;
        this.rank = 0;
    }

    /**
    * 会員の情報を初期化する
    * @param id 会員ID
    * @param password パスワード
    * @param name 会員の名前
    * @param age 会員の年齢
    * @param rank 会員のランク
    */
    public Member(int id, String password, String name, int age, int rank) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.rank = rank;
    }

        /**
        * 会員の情報を表示するメソッド
        */
    public void showMember() {
        System.out.println("***MEMBER DATA***");
        System.out.println("id:" + id);
        System.out.println("password:" + password);
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        System.out.println("rank:" + rank);
        System.out.println("*****************");
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
