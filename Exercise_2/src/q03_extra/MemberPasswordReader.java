package q03_extra;
/**
 * 会員パスワードの入力を受け付けるクラス
 * IConsoleReaderインターフェースを実装する
 */
public class MemberPasswordReader implements IConsoleReader {
    @Override
    public String setErrorMsg() {
        return "8 文字以上 16 文字以内の半角英数字で入力してください";
    }

    @Override
    public boolean isValid(String inputString) {
        return inputString.matches("^[a-zA-Z0-9]{8,16}$");
    }

    @Override
    public boolean isParseInt() {
        return false;
    }

}
