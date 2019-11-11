package name.guolanren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guolanren
 */
@Configuration
public class SomeConfiguration {

    @Bean
    public String sth() {
        return "Hello, World";
    }

}
