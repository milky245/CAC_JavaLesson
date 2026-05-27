package empsys.service;

import java.time.LocalDate;
import java.time.Period;

abstract class EmpEmployee {
    protected String id;
    protected String name;
    protected int genderIndex;
    protected LocalDate birthday;
    protected LocalDate hireDate;
    protected int deptIndex;
    protected int baseSalary;
    protected int allowance;
    protected boolean hasHomeAllowance;
    protected int deduction;
    protected int attendance;
    protected int expectedWorkdays;
    protected int homeAllowance;
    protected int payRaise;

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

    public EmpEmployee(String id, String name, int gender, LocalDate birthday, LocalDate hireDate, int dept,
                       int baseSalary, int allowance, boolean hasHomeAllowance, int deduction,
                       int attendance, int expectedWorkdays, int homeAllowance, int payRaise) {
        this.id = id;
        this.name = name;
        this.genderIndex = gender;
        this.birthday = birthday;
        this.hireDate = hireDate;
        this.deptIndex = dept;
        this.baseSalary = baseSalary;
        this.allowance = allowance;
        this.hasHomeAllowance = hasHomeAllowance;
        this.deduction = deduction;
        this.attendance = attendance;
        this.expectedWorkdays = expectedWorkdays;
        this.homeAllowance = homeAllowance;
        this.payRaise = payRaise;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGenderIndex() {
        return genderIndex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int calcAge() {
        LocalDate today = LocalDate.now();
        return Period.between(this.birthday, today).getYears();
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * 勤続年数を計算する.
     * 説明：
     * ・入社日から今日までの年数
     * ・1年未満は切り捨て
     */
    public int calcServiceYears() {

        if (hireDate == null) {
            return 0;
        }

        LocalDate today = LocalDate.now();
        return Period.between(this.hireDate, today).getYears();
    }

    public int getDeptIndex() {
        return deptIndex;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getAllowance() {
        return allowance;
    }

    public boolean getHomeAllowance() {
        return hasHomeAllowance;
    }

    public boolean isHomeAllowanceProvided() {
        return hasHomeAllowance;
    }

    public boolean getHasHomeAllowance() {
        return hasHomeAllowance;
    }

    public int getDeduction() {
        return deduction;
    }

    public int getAttendance() {
        return attendance;
    }

    /**
     * 説明.
     * 月給（メニュー画面/検索結果中の「差引支給額」）の値を計算して返す
     */
    public abstract int sumSalary();
}

