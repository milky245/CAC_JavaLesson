package q03_extra;

/**
 * 会員IDを読み取るクラス
 * 1-9の整数を入力することを想定している
 */
public class MemberIdReader implements IConsoleReader {
    @Override
    public String setErrorMsg() {
        return "1-9 の整数を入力してください";
    }

    @Override
    public boolean isValid(String inputString) {
        return inputString.matches("[1-9]");
    }

    @Override
    public boolean isParseInt() {
        return true;
    }

}
