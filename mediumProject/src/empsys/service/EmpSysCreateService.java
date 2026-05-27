package empsys.service;

import empsys.repository.EmpEmployeeEntity;
import empsys.repository.EmpRepository;
import java.time.LocalDate;


/**
 * 社員情報登録機能.
 */
public class EmpSysCreateService {
    EmpRepository repository;

    /**
     * コンストラクタ.
     *
     * @param repository EmpRepository リポジトリ層機能のインスタンス
     */
    public EmpSysCreateService(EmpRepository repository) {
        this.repository = repository;
    }

    /**
     * コンストラクタ.
     *
     * @param id               - 社員番号
     * @param name             - 名前
     * @param gender           - 性別インデックス
     * @param birthday         - 生年月日
     * @param hireDate         - 入社日
     * @param dept             - 所属部署インデックス
     * @param baseSalary       - 基本給
     * @param allowance        - 各手当（共通手当の合計額）
     * @param hasHomeAllowance - 住宅手当の有無 (true: あり, false: なし)
     * @param deduction        - 控除額
     * @param post             - 役職インデックス
     * @return オブジェクト出力
     */

    public EmpServiceResult createEmployee(String id, String name, int gender,
                                           LocalDate birthday, LocalDate hireDate,
                                           int dept, int post, int baseSalary,
                                           int allowance, boolean hasHomeAllowance, int deduction) {

        EmpEmployeeEntity employee = new EmpEmployeeEntity();
        employee.id = id;
        employee.name = name;
        employee.gender = gender;
        employee.birthday = birthday;
        employee.hireDate = hireDate;
        employee.deptIndex = dept;
        employee.postIndex = post;
        employee.baseSalary = baseSalary;
        employee.allowance = allowance;
        employee.hasHomeAllowance = hasHomeAllowance;
        employee.deduction = deduction;

        int reCreate = repository.create(employee);
        if (reCreate == 0) {
            return new EmpServiceResult(false,
                    String.format("社員番号(%s)の情報登録失敗: データは既に存在する", id));
        } else {
            return new EmpServiceResult(true,
                    String.format("社員番号(%s)の情報登録、正常終了", id));
        }
    }

}
