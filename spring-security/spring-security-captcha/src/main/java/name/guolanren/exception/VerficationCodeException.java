package name.guolanren.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author guolanren
 */
public class VerficationCodeException extends AuthenticationException {

    public VerficationCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public VerficationCodeException(String msg) {
        super(msg);
    }
}
