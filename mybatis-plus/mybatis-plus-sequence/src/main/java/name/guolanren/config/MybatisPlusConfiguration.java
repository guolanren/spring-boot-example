package name.guolanren.config;

import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author guolanren
 */
@Configuration
@EnableTransactionManagement
@MapperScan("name.guolanren.mapper")
public class MybatisPlusConfiguration {

    /**
     * 主键生成器
     */
    @Bean
    public H2KeyGenerator h2KeyGenerator(){
        return new H2KeyGenerator();
    }

}
