package name.guolanren.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
public class ChattingController {

    @MessageMapping("/chat")
    @SendTo("/topic/chatting")
    public String chatting(String message) {
        return message;
    }

}
