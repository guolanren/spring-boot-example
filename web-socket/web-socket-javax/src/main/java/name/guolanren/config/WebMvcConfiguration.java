package name.guolanren.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author guolanren
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public ServletListenerRegistrationBean<HttpRequestListener> httpRequestListener() {
        ServletListenerRegistrationBean<HttpRequestListener> httpRequestListener = new ServletListenerRegistrationBean<>();
        httpRequestListener.setListener(new HttpRequestListener());
        return httpRequestListener;
    }

}
