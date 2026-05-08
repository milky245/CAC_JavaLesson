package q02_advanced.question03;

/**
 * MemberStorageにアクセスし、ログイン処理を行う
 */
class LoginService {

	/**
	 * memberStorage Memberクラスのリスト一覧
	 */
	private MemberStorage memberStorage;

	//TODO ここから処理を記述
	public LoginService(MemberStorage memberStorage) {
		this.memberStorage = memberStorage;
	}

	/**
	 * ログイン処理を行う
	 * @param id 会員ID
	 * @param password パスワード
	 * @return ログイン成功した場合はMemberクラスのインスタンス、失敗した場合はnullを返す
	 */
	public Member doLogin(int id, String password) {
		for (Member member : memberStorage.getMembers()) {
			if (member.getId() == id && member.getPassword().equals(password)) {
				return member;
			}
		}
		return null;
	}

}
