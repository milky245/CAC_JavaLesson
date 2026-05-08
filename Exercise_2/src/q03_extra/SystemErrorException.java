package q03_extra;
/** * SystemErrorException クラス：下記クラス構成、クラス図を参照しコンストラクタを定義する。コンストラクタ内の処理で親
 * クラス（Exception）のコンストラクタを呼び出す。
 */
public class SystemErrorException extends Exception {
    //SystemErrorException クラス：下記クラス構成、クラス図を参照しコンストラクタを定義する。コンストラクタ内の処理で親
    //クラス（Exception）のコンストラクタを呼び出す。

    public SystemErrorException(){
        	super();
    }

    public SystemErrorException(String message){
        	super(message);
    }

    public SystemErrorException(String message, Throwable cause){
        	super(message, cause);
    }

    public SystemErrorException(String message, Throwable cause, boolean enabledSuppression, boolean writableStackTrace){
        	super(message, cause, enabledSuppression, writableStackTrace);
    }

    public SystemErrorException(Throwable cause){
        	super(cause);
    }
}
