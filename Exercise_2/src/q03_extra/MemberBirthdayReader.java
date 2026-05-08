package q03_extra;
/**
 * 会員の誕生日を読み取るクラス
 * IConsoleReaderインターフェースを実装する
 */
public class MemberBirthdayReader implements IConsoleReader {
    @Override
    public String setErrorMsg() {
        return "正しい形式(yyyy/MM/dd)で入力してください";
    }

    /**
     * 引数で取得した inputString が指定の形式
     * （yyyy/MM/dd 形式）と一致する場合は、戻り値として true、一致しない場合は false を返す。
     * ※形式チェックは SimpleDateFormat を使用して実装することができる。
     * ※存在しない日付が入力された場合も false とする。
     */
    @Override
    public boolean isValid(String inputString) {
    // Implement date format validation logic here
    //引数で取得した inputString が指定の形式
    //（yyyy/MM/dd 形式）と一致する場合は、戻り値として true、一致しない場合は false を返す。
    //※形式チェックは SimpleDateFormat を使用して実装することができる。
    //※存在しない日付が入力された場合も false とする。
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
            sdf.setLenient(false); // 厳密な日付チェックを行う（不允许宽松模式匹配日期）
            sdf.parse(inputString); // 形式と存在する日付かをチェック
            return true; // 形式が正しく、存在する日付の場合はtrueを返す
        } catch (java.text.ParseException e) {
            return false; // 形式が正しくない、または存在しない日付の場合はfalseを返す
        }
    }

    @Override
    public boolean isParseInt() {
        return false;
    }

}
