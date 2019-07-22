package name.guolanren.exception;

/**
 * @author guolanren
 */
public class ServerErrorException extends RuntimeException {

    private static final long serialVersionUID = 8357096485790269600L;

    public ServerErrorException() {
        super();
    }

    public ServerErrorException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerErrorException(String message) {
        super(message);
    }

    public ServerErrorException(Throwable cause) {
        super(cause);
    }
}
