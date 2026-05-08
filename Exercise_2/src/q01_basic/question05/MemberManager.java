package q01_basic.question05;
/**
 * 会員管理クラス
 * 会員の情報を表示するメソッドを持つ。
 */
class MemberManager {

	/**
	 * インスタンス化の禁止
	 */
	private MemberManager() {
	}

	//TODO showAllMembersメソッドを実装する
	public static void showAllMembers(Member[] members) {
		for (Member member : members) {
			member.showMember(); // 各会員の情報を表示
		}
	}

}
