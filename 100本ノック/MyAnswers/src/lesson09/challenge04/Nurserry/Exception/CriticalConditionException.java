package lesson09.challenge04.Nurserry.Exception;

//need to extend Throwable class
public class CriticalConditionException extends Throwable {
    private final String message;

    public CriticalConditionException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
