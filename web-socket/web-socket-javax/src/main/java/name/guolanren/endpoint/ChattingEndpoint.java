package name.guolanren.endpoint;

import name.guolanren.config.WebSocketJavaxConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guolanren
 */
@ServerEndpoint(value = "/chat", configurator = WebSocketJavaxConfiguration.HttpSessionConfigurator.class)
@Component
public class ChattingEndpoint {

    private List<WebSocketSession> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        System.out.println("open...");

//        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        if (httpSession == null) {
//            session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, "找不到 HTTP 会话"));
//        }

    }

    @OnClose
    public void onClose() {
        System.out.println("close...");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
