package name.guolanren.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * CORS方式五
 *
 * @author guolanren
 * @date 2019-04-03
 */
@Component
@Order(-1024)
@WebFilter(filterName = "corsFilter",urlPatterns = "/*")
public class CorsFilter implements Filter {

    @Value("${spring.http.header.access-control-allow-origins}")
    private String[] ALLOWED_ORIGINS;

    @Value("${spring.http.header.access-control-allow-methods}")
    private String[] ALLOWED_METHODS;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Set<String> allowedOrigins = new HashSet(Arrays.asList(ALLOWED_ORIGINS));
        Set<String> allowedMethods = new HashSet(Arrays.asList(ALLOWED_METHODS));


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String origin = request.getHeader(HttpHeaders.ORIGIN);
        String headers = request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS);
        String methods = request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD);
        if(allowedOrigins.contains(origin)) {
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        }
        if(allowedMethods.contains(methods)) {
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, methods);
        }
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, headers);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
