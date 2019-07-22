package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableScheduling
public class ApiAuditingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAuditingApplication.class, args);
    }

}
