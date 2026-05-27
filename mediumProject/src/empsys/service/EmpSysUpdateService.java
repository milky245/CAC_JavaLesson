package empsys.service;

import empsys.repository.EmpEmployeePayrollInfo;
import empsys.repository.EmpRepository;

/**
 * 社員情報更新機能を提供するサービスクラス.
 */
public class EmpSysUpdateService {

    private EmpRepository repository;

    /**
     * コンストラクタ.
     *
     * @param repository リポジトリ層インスタンス
     */
    public EmpSysUpdateService(EmpRepository repository) {
        this.repository = repository;
    }

    /**
     * 社員情報を更新する.
     *
     * @param id               社員番号
     * @param dept             所属部署インデックス
     * @param post             役職インデックス
     * @param baseSalary       基本給
     * @param allowance        各手当（合計）
     * @param hasHomeAllowance 住宅手当の有無
     * @param deduction        控除額
     * @return EmpServiceResult 実行結果
     */
    public EmpServiceResult updateEmployee(
            String id,
            int dept,
            int post,
            int baseSalary,
            int allowance,
            boolean hasHomeAllowance,
            int deduction) {

        EmpEmployeePayrollInfo entity = repository.findById(id);

        if (entity == null) {
            return new EmpServiceResult(
                    false,
                    String.format("社員番号(%s)の情報更新失敗: データが存在しない", id));
        }

        entity.deptIndex = dept;
        entity.postIndex = post;
        entity.baseSalary = baseSalary;
        entity.allowance = allowance;
        entity.hasHomeAllowance = hasHomeAllowance;
        entity.deduction = deduction;

        repository.update(id, entity);
        return new EmpServiceResult(
                true,
                String.format("社員番号(%s)の情報更新、正常終了", id));
    }
}

