package name.guolanren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Mybatis 审计
 *
 * @author 郭耀展
 */
@SpringBootApplication
@MapperScan("com.leayun.bdc.dao")
public class MybatisAuditingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAuditingApplication.class, args);
    }

}
