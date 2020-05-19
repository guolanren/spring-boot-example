package name.guolanren.service;

/**
 * @author guolanren
 */
public class FtpServer implements Server {
    public void start() {
        System.out.println("FTP 服务器启动中...");
    }

    public void stop() {
        System.out.println("FTP 服务器关闭中");
    }
}
