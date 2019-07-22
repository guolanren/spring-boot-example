package name.guolanren.exception;

/**
 * @author guolanren
 */
public class InvalidParamException extends RuntimeException{

    private static final long serialVersionUID = 975102355123055799L;

    public InvalidParamException() {
        super();
    }

    public InvalidParamException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParamException(String message) {
        super(message);
    }

    public InvalidParamException(Throwable cause) {
        super(cause);
    }
}
