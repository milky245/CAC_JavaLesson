package empsys.service;

import java.time.LocalDate;
import java.time.Period;

/**
 * 従業員クラス（一般社員）.
 * 給料計算
 * 試用期間、税控除、昇給を考慮
 */
public class EmpStaff extends EmpEmployee {
    /** 売上高に対する係数. */
    protected static final double K_SALES = 0.02;

    /** 税金控除免除限度額. */
    protected static final int TAX_FREE_LIMIT = 10000;

    /** 試用期間中の給与差し引き額. */
    protected static final int DEDUCTION_PROBATION = 30000;

    /** 試用期間の長さ（月数）. */
    protected static final int PROBATION_PERIOD = 3;

    /** 当月売上高. */
    protected int sales = 0;

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
     * @param sales            - 当月売上高
     * @param homeAllowance    - 共用定数 住宅手当
     * @param payRaise         - 共用定数 昇給額（年間）
     */

    public EmpStaff(String id, String name, int gender, LocalDate birthday, LocalDate hireDate,
                    int dept, int baseSalary, int allowance, boolean hasHomeAllowance, int deduction, int attendance, int sales,
                    int expectedWorkdays, int homeAllowance, int payRaise) {
        super(id, name, gender, birthday, hireDate,
                dept, baseSalary, allowance, hasHomeAllowance,
                deduction, attendance, expectedWorkdays,
                homeAllowance, payRaise);
        this.sales = sales;
    }

    /**
     * 試用期間中かどうか判定.
     *
     * @return true: 試用期間中 / false: 試用期間外
     *
     *         処理内容：
     *         ・入社日から現在までの月数を計算
     *         ・PROBATION_PERIOD 未満なら true
     */

    public boolean isUnderProbation() {
        if (hireDate == null) {
            return false;
        }

        LocalDate today = LocalDate.now();
        Period period = Period.between(hireDate, today);

        return period.getMonths() < PROBATION_PERIOD
                && period.getYears() == 0;
    }

    /** 当月の月給を返す. */
    @Override
    public int sumSalary() {

        int serviceYears = calcServiceYears();
        int salesBonus = (int) (sales * K_SALES);

        int salary = baseSalary
                + allowance
                + salesBonus
                + (serviceYears * payRaise)
                - deduction;

        if (serviceYears < 1 && deduction > TAX_FREE_LIMIT) {
            salary += TAX_FREE_LIMIT;
        }

        if (isUnderProbation()) {
            salary -= DEDUCTION_PROBATION;
        }

        return salary;
    }
}

