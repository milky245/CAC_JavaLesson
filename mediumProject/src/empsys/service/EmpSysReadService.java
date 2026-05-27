package empsys.service;

import empsys.repository.EmpEmployeePayrollInfo;
import empsys.repository.EmpRepository;
import java.util.ArrayList;

/**
 * 社員情報取得機能を提供するサービスクラス.
 */
public class EmpSysReadService {

    public static final int POST_STAFF = 1;
    public static final int POST_SECTIONCHIEF = 2;
    public static final int POST_GENERALMANAGER = 3;
    // - 説明: 役職インデックス（1：従業員, 2：課長, 3：部長）
    private EmpRepository repository;
    // - 説明: リポジトリ層機能のインスタン.

    /**
     * コンストラクタ.
     *
     * @param repository リポジトリ層インスタンス
     */
    public EmpSysReadService(EmpRepository repository) {
        this.repository = repository;
    }

    /**
     * エンティティをサービス用オブジェクトに変換.
     *
     * @param entity 社員エンティティ
     * @return EmpEmployee
     */
    protected EmpEmployee createEmployee(EmpEmployeePayrollInfo entity) {

        if (entity == null) {
            return null;
        }

        switch (entity.postIndex) {

            case POST_STAFF:
                return new EmpStaff(
                        entity.id,
                        entity.name,
                        entity.gender,
                        entity.birthday,
                        entity.hireDate,
                        entity.deptIndex,
                        entity.baseSalary,
                        entity.allowance,
                        entity.hasHomeAllowance,
                        entity.deduction,
                        entity.attendance,
                        entity.expectedWorkdays,
                        entity.homeAllowance,
                        entity.payRaise,
                        entity.sales);

            case POST_SECTIONCHIEF:
                return new EmpSectionChief(

                        entity.id,
                        entity.name,
                        entity.gender,
                        entity.birthday,
                        entity.hireDate,
                        entity.deptIndex,
                        entity.baseSalary,
                        entity.allowance,
                        entity.hasHomeAllowance,
                        entity.deduction,
                        entity.attendance,
                        entity.expectedWorkdays,
                        entity.homeAllowance,
                        entity.payRaise);

            case POST_GENERALMANAGER:
                return new EmpGeneralManager(

                        entity.id,
                        entity.name,
                        entity.gender,
                        entity.birthday,
                        entity.hireDate,
                        entity.deptIndex,
                        entity.baseSalary,
                        entity.allowance,
                        entity.hasHomeAllowance,
                        entity.deduction,
                        entity.attendance,
                        entity.expectedWorkdays,
                        entity.homeAllowance,
                        entity.payRaise);

            default:
                return null;
        }
    }

    /**
     * 全社員情報を取得.
     *
     * @return EmpReadServiceResult
     */

    public EmpReadServiceResult getAllEmployee() {

        ArrayList<EmpEmployee> employees = new ArrayList<>(
                repository.findAll().stream().map(x -> createEmployee(x)).toList());

        if (employees.isEmpty()) {
            return new EmpReadServiceResult(
                    false,
                    "全社員情報取得: 社員情報が存在しない",
                    new ArrayList<>());
        } else {
            return new EmpReadServiceResult(
                    true,
                    String.format("全社員情報(%d件)取得: 正常終了", employees.size()),
                    employees);
        }
    }

    /**
     * 社員IDで検索.
     *
     * @param id 社員番号
     * @return EmpReadServiceResult
     */
    public EmpReadServiceResult queryEmployee(String id) {
        EmpEmployeePayrollInfo employee = repository.findById(id);
        if (employee == null) {
            return new EmpReadServiceResult(
                    false,
                    String.format("社員番号(%s)の情報取得失敗: データが存在しない", id),
                    new ArrayList<>());
        } else {
            ArrayList<EmpEmployee> list = new ArrayList<>();
            list.add(createEmployee(employee));

            return new EmpReadServiceResult(
                    true,
                    String.format("社員番号(%s)の情報取得、正常終了", id),
                    list);
        }
    }
}