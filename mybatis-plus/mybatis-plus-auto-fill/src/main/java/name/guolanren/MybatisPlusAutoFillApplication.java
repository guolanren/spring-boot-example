package name.guolanren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
@MapperScan("name.guolanren.mapper")
public class MybatisPlusAutoFillApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusAutoFillApplication.class, args);
    }

}
