package q03_extra;

/**
 * MemberStorageにアクセスし、ユーザ登録処理を行う
 */
class CreateUserService {
	/**
	 * memberStorage Memberクラスのリスト一覧
	 */
	private MemberStorage memberStorage;

	//TODO ここから実装する
	//コンストラクタを定義する。引数で取得した memberStorage をフィールドに代入する。
	public CreateUserService(MemberStorage memberStorage) {
		this.memberStorage = memberStorage;
	}

	/**
	 * ユーザ登録処理を行う
	 * @param id 会員ID
	 * @param password パスワード
	 * @param name 会員の名前
	 * @param birthday 会員の誕生日
	 * @return 登録成功の場合はtrue、失敗の場合はfalseを返す
	 * @throws IllegalInputException 入力が不正な場合にスローされる例外
	 */
	public boolean execute(int id, String password, String name, String birthday) throws IllegalInputException {
		for (Member member : memberStorage.getMembers()) {
			if (member.getId() == id) {
				throw new IllegalInputException("IDが重複しています。再度入力してください");
			}
		}
		Member newMember = Member.getInstance(id, password, name, birthday);
		memberStorage.addMember(newMember);
		return true;
	}

}
