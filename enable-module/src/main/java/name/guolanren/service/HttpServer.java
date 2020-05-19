package name.guolanren.service;

/**
 * @author guolanren
 */
public class HttpServer implements Server {
    public void start() {
        System.out.println("HTTP 服务器启动中...");
    }

    public void stop() {
        System.out.println("HTTP 服务器关闭中");
    }
}
