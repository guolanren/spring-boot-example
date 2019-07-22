package name.guolanren.service;

/**
 * @author guolanren
 */
public interface EmailService {

    void send(String who);

    void sendWithAttachment(String who);

    void sendByHTML(String who);
}
