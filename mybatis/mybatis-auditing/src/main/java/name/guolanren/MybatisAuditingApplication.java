package name.guolanren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
@MapperScan("name.guolanren.dao")
public class MybatisAuditingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAuditingApplication.class, args);
    }

}
