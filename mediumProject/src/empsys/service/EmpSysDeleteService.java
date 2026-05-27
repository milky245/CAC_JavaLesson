package empsys.service;

import empsys.repository.EmpRepository;

/**
 * 社員情報削除機能を提供するサービスクラス.
 */
public class EmpSysDeleteService {
    private EmpRepository repository;

    /**
     * コンストラクタ.
     *
     * @param repository リポジトリ層インスタンス
     */
    public EmpSysDeleteService(EmpRepository repository) {
        this.repository = repository;
    }

    /**
     * 社員を削除する.
     *
     * @param id 削除対象の社員番号
     * @return EmpServiceResult 実行結果
     */
    public EmpServiceResult deleteEmployee(String id) {

        int result = repository.delete(id);

        if (result == 0) {
            return new EmpServiceResult(
                    false,
                    String.format("社員番号(%s)の情報削除失敗: データが存在しない", id));
        }

        return new EmpServiceResult(
                true,
                String.format("社員番号(%s)の情報削除、正常終了", id));
    }

    /**
     * 全社員情報を削除する.
     *
     * @return EmpServiceResult 実行結果
     */
    public EmpServiceResult deleteAllEmployee() {

        int count = repository.deleteAll();

        return new EmpServiceResult(
                true,
                String.format("全社員情報(%d件)削除、正常終了", count));
    }
}

