package empsys.service;

import java.time.LocalDate;

/**
 * 課長.
 * 給料計算
 */
public class EmpSectionChief extends EmpEmployee {
    /**
     * 係数（基本給）.
     *
     * @param K_SALARY .
     */
    protected static final double K_SALARY = 1.25;

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
    public EmpSectionChief(String id, String name, int gender, LocalDate birthday, LocalDate hireDate, int dept,
                           int baseSalary, int allowance, boolean hasHomeAllowance, int deduction,
                           int attendance, int expectedWorkdays, int homeAllowance, int payRaise) {
        super(id, name, gender, birthday, hireDate, dept, baseSalary, allowance, hasHomeAllowance, deduction,
                attendance, expectedWorkdays, homeAllowance, payRaise);
    }

    /** 当月の月給を返す. */
    @Override
    public int sumSalary() {
        int sum = (int) Math.round(
                baseSalary * K_SALARY
                        + allowance
                        + calcServiceYears() * payRaise
                        - deduction);
        return sum;
    }
}
