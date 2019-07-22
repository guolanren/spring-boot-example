package name.guolanren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

/**
 * @author guolanren
 */
@Configuration
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<Integer> auditorAware() {
        return new AuditorAwareImpl();
    }


    class AuditorAwareImpl implements AuditorAware<Integer> {
        @Override
        public Optional<Integer> getCurrentAuditor() {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            Integer userId = ((User)servletRequestAttributes.getRequest().getSession().getAttribute("user")).getId();
            return Optional.of(1);
        }
    }

}
