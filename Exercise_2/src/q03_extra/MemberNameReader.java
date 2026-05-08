package q03_extra;
/**
 * 会員名の入力を受け付けるクラス
 * IConsoleReaderインターフェースを実装する
 */
public class MemberNameReader implements IConsoleReader {
    @Override
    public String setErrorMsg() {
        return "名前は半角英字 16 文字以内で入力してください";
    }

    @Override
    public boolean isValid(String inputString) {
        return inputString.matches("^[a-zA-Z]{1,16}$");
    }

    @Override
    public boolean isParseInt() {
        return false;
    }

}
