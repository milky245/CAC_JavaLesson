package q03_extra;
/**
 * IllegalInputException クラス：ユーザーの入力が不正な場合にスローされる例外クラス。
 * Exception クラスを継承し、以下のコンストラクタを定義する。
 * - IllegalInputException()
 * - IllegalInputException(String message)
 * - IllegalInputException(String message, Throwable cause)
 * - IllegalInputException(String message, Throwable cause, boolean enabledSuppression, boolean writableStackTrace)
 * - IllegalInputException(Throwable cause)
 */
public class IllegalInputException extends Exception {
    //IllegalInputException クラス：下記クラス構成、クラス図を参照しコンストラクタを定義する。コンストラクタ内の処理で親
    //クラス（Exception）のコンストラクタを呼び出す。

    public IllegalInputException() {
        super();
    }

    public IllegalInputException(String message) {
        super(message);
    }

    public IllegalInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalInputException(String message, Throwable cause, boolean enabledSuppression, boolean writableStackTrace) {
        super(message, cause, enabledSuppression, writableStackTrace);
    }

    public IllegalInputException(Throwable cause) {
        super(cause);
    }


}
