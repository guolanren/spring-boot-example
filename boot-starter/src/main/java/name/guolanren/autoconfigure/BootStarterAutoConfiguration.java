package name.guolanren.autoconfigure;

import name.guolanren.service.BootStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guolanren
 */
@Configuration
@EnableConfigurationProperties(BootStarterProperties.class)
public class BootStarterAutoConfiguration {

    @Autowired
    private BootStarterProperties bootStarterProperties;

    @Bean
    @ConditionalOnMissingBean(BootStarterService.class)
    public BootStarterService bootStarterService() {
        BootStarterService bootStarterService = new BootStarterService();
        bootStarterService.setMsg(bootStarterProperties.getMsg());
        return bootStarterService;
    }

}
