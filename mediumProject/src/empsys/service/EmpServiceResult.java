package empsys.service;

/**
 * サービス層の処理結果を表すクラス.
 */
public class EmpServiceResult {
    public final boolean success;
    public final String message;

    /**
     * コンストラクタ₋外部から初期値設定.
     *
     * @param success 処理の実行結果（true: 成功, false: 失敗）.
     * @param message 処理に関するメッセージ。成功・失敗の内容を含む.
     */
    public EmpServiceResult(boolean success, String message) {
        this.message = message;
        this.success = success;
    }
}
