package name.guolanren.exception;

/**
 * @author guolanren
 */
public class SessionInvalidException extends RuntimeException {

    public SessionInvalidException() {
        super();
    }

    public SessionInvalidException(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SessionInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionInvalidException(String message) {
        super(message);
    }

    public SessionInvalidException(Throwable cause) {
        super(cause);
    }
}
