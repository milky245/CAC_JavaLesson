package q03_extra;
/**
 * 会員管理クラス
 * 会員の情報を表示するメソッドを持つ。
 */
import java.util.List;

class MemberManager {

    /**
     * インスタンス化の禁止
     */
    private MemberManager() {
    }

    //TODO showAllMembersメソッドを実装する
    public static void showAllMembers(List<Member> members) {
        for (Member member : members) {
            member.showMember(); // 会員の情報を表示
        }
    }

    /**
     * 会員のパスワードを更新するメソッド
     * idが一致する会員のパスワードをnewPasswordに更新します。
     * 一致する会員がいない場合は「該当者はいませんでした。」と表示します。
     */
    public static void updatePassword(List<Member> members, int id, String newPassword) {
        boolean found = false;
        for (Member member : members) {
            if (member.getId() == id) { // id一致する会員を探す
                member.setPassword(newPassword); // パスワードを更新
                found = true;
                System.out.println("パスワードが更新されました。");
                break; // 一致する会員が見つかったらループを抜ける
            }
        }
        if (!found) {
            System.out.println("該当者はいませんでした。");
        }
    }

    /**
     * 会員の情報を表示するメソッド
     * idが一致する会員の情報を表示します。
     * 一致する会員がいない場合は「該当者はいませんでした。」と表示します。
     */
    public static void showCreateUser(List<Member> members, int id) {
        for (Member member : members) {
            if (member.getId() == id) { // id一致する会員を探す
                member.showMember(); // 該当会員の情報を表示
                return; // 一致する会員が見つかったらメソッドを終了
            }
        }
        System.out.println("該当者はいませんでした。");
    }
}
