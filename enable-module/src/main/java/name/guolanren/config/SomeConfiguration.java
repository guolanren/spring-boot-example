package name.guolanren.config;

import name.guolanren.service.HttpServer;
import name.guolanren.service.Server;
import org.springframework.context.annotation.Bean;

/**
 * @author guolanren
 */
public class SomeConfiguration {

    @Bean
    public Server httpServer() {
        return new HttpServer();
    }

}
