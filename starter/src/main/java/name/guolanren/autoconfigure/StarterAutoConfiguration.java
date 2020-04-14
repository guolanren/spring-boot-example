package name.guolanren.autoconfigure;

import name.guolanren.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author guolanren
 */
@Configuration
@ComponentScan("name.guolanren")
@EnableConfigurationProperties(StarterProperties.class)
@ConditionalOnExpression("true")
@Import({})
public class StarterAutoConfiguration {

    @Autowired
    private StarterProperties starterProperties;

    @Bean
    @ConditionalOnMissingBean(StarterService.class)
    public StarterService bootStarterService() {
        StarterService starterService = new StarterService();
        starterService.setMsg(starterProperties.getMsg());
        return starterService;
    }

}
