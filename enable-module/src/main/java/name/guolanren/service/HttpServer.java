package name.guolanren.service;

import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class HttpServer implements Server {
    public void start() {
        System.out.println("HTTP 服务器启动中...");
    }

    public void stop() {
        System.out.println("HTTP 服务器关闭中");
    }
}
