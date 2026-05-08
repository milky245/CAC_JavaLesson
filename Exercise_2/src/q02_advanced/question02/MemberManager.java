package q02_advanced.question02;
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

    //MemberManager クラス：showAllMembers メソッドを定義する。引数で取得した複数の Member クラスオブジェクトを 1 件ずつ取得し、各オブジェクトの showMember メソッドを呼び出す。
    //TODO showAllMembersメソッドを実装する
    public static void showAllMembers(List<Member> members) {
        for (Member member : members) {
            member.showMember(); // 会員の情報を表示
        }
    }

    /**
     * updatePassword メソッドを定義する。引数で取得した複数の Member クラスオブジェクトから、引数で取得した id と一致する会員を探し、その会員のパスワードを引数で取得した newPassword に更新する。
     * @param members
     * @param id
     * @param newPassword
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
}
