package name.guolanren;

import name.guolanren.annotation.EnableByImportConfiguration;
import name.guolanren.annotation.EnableByImportImportBeanDefinitionRegistrar;
import name.guolanren.annotation.EnableByImportImportSelector;
import name.guolanren.service.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableByImportConfiguration
//@EnableByImportImportSelector(type = Server.Type.HTTP)
//@EnableByImportImportBeanDefinitionRegistrar(type = Server.Type.HTTP)
public class EnableModuleApplication implements CommandLineRunner {

    @Autowired
    private Server server;

    public static void main(String[] args) {
        SpringApplication.run(EnableModuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        server.stop();
    }
}
