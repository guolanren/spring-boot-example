package name.guolanren.exception;

/**
 * @author guolanren
 */
public class ExpiredSessionException extends RuntimeException {

    private static final long serialVersionUID = 7484041979257823063L;

    public ExpiredSessionException() {
        super();
    }

    public ExpiredSessionException(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExpiredSessionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredSessionException(String message) {
        super(message);
    }

    public ExpiredSessionException(Throwable cause) {
        super(cause);
    }
}
