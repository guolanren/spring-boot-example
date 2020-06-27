package name.guolanren.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guolanren
 */
@RestController
public class ChattingController extends TextWebSocketHandler {

    private List<WebSocketSession> sessions = new ArrayList<>();

    @PostMapping("/chat")
    public String chatting(@RequestBody String message) throws IOException {
        for (WebSocketSession session : sessions) {
            session.sendMessage(new TextMessage(message.toUpperCase()));
        }
        return null;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String receiveMsg = (String) message.getPayload();
        String sendMsg = receiveMsg.toUpperCase();
        session.sendMessage(new TextMessage(sendMsg));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        super.afterConnectionClosed(session, status);
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }
}
