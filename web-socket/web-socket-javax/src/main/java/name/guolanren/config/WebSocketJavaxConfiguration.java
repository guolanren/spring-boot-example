package name.guolanren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author guolanren
 */
@Configuration
public class WebSocketJavaxConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    public static class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {

        @Override
        public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
            super.modifyHandshake(sec, request, response);
            HttpSession httpSession = (HttpSession) request.getHttpSession();
            sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
        }
    }
}