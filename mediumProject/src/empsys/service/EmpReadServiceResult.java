package empsys.service;

import java.util.ArrayList;

/**
 * サービス層の検索処理結果を表すクラス.
 */
public class EmpReadServiceResult extends EmpServiceResult {
    public final ArrayList<EmpEmployee> employeeList;

    /**
     * コンストラクタ.
     *
     * @param success   - 実行結果 (true=成功, false=失敗)
     * @param message   - 実行メッセージ（成功／失敗内容)
     * @param employees ₋ 検索結果の社員情報リスト
     */
    public EmpReadServiceResult(boolean success, String message, ArrayList<EmpEmployee> employees) {
        super(success, message);
        this.employeeList = employees;
    }

}

