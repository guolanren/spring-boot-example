package name.guolanren.config;

import name.guolanren.controller.ChattingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * @author guolanren
 */
@Configuration
@EnableWebSocket
public class WebSocketHandlerConfiguration implements WebSocketConfigurer {

    @Autowired
    private ChattingController webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler, "/web-socket")
                .addInterceptors(handshakeInterceptor())
                .setAllowedOrigins("*");

//        webSocketHandlerRegistry.addHandler(webSocketHandler(), "/web-socket")
//                .addInterceptors(handshakeInterceptor())
//                .setAllowedOrigins("*")
//                .withSockJS();
    }

    @Bean
    public HttpSessionHandshakeInterceptor handshakeInterceptor() {
        return new MyHttpSessionHandshakeInterceptor();
    }
}