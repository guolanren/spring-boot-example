package name.guolanren.service;

/**
 * @author guolanren
 */
public interface Server {


    void start();

    void stop();

    enum Type {
        HTTP,
        FTP
    }
}
