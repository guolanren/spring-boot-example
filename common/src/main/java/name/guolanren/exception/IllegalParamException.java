package name.guolanren.exception;

/**
 * @author guolanren
 */
public class IllegalParamException extends RuntimeException {

    public IllegalParamException() {
        super();
    }

    public IllegalParamException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IllegalParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParamException(String message) {
        super(message);
    }

    public IllegalParamException(Throwable cause) {
        super(cause);
    }
}
