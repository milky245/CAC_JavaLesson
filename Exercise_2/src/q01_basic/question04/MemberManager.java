package q01_basic.question04;
/**
 * 会員管理クラス
 * Memberクラスの配列を受け取り、すべての会員情報を表示するメソッドを持つ。
 */
class MemberManager {

	/**
	 * インスタンス化の禁止
	 */
	private MemberManager() {
	}

	//TODO showAllMembersメソッドを実装する
	/*
	 * すべての会員情報を表示する
	 * @param members 会員の配列
	 */
	public static void showAllMembers(Member[] members) {
		for (Member member : members) {
			member.showMember(); // 各会員の情報を表示
		}
	}

}
