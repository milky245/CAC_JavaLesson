package empsys.service;

import java.time.LocalDate;

/**
 * 部長.
 * 給料計算
 * 税控除、昇給、特別手当を考慮
 */
public class EmpGeneralManager extends EmpEmployee {
    /**
     * 定数.
     *
     * @param K_SALARY          係数（基本給）.
     * @param SPECIAL_ALLOWANCE 特別手当.
     */

    protected static final double K_SALARY = 1.5;
    protected static final int SPECIAL_ALLOWANCE = 20000;

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
     * @param attendance       - 当月出勤日数（実績または予定）
     * @param expectedWorkdays - 当月標準勤務日数
     * @param homeAllowance    - 共用定数 住宅手当
     * @param payRaise         - 共用定数 昇給額（年間）
     */

    public EmpGeneralManager(String id, String name, int gender, LocalDate birthday, LocalDate hireDate, int dept,
                             int baseSalary, int allowance, boolean hasHomeAllowance, int deduction, int attendance,
                             int expectedWorkdays,
                             int homeAllowance, int payRaise) {
        super(id, name, gender, birthday, hireDate, dept, baseSalary, allowance, hasHomeAllowance, deduction,
                attendance,
                expectedWorkdays, homeAllowance, payRaise);
    }

    /**
     * 当月の月給を返す.
     */

    @Override
    public int sumSalary() {

        int serviceYears = calcServiceYears();

        int salary = (int) (baseSalary * K_SALARY)
                + allowance
                + SPECIAL_ALLOWANCE
                + (serviceYears * payRaise)
                - deduction;

        return salary;
    }
}
