package name.guolanren.impl;

import name.guolanren.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guolanren
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmailServiceImplTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSend() {
        emailService.send("lanrenguo@gmail.com");
    }

    @Test
    public void testSendByHTML() {
        emailService.sendByHTML("lanrenguo@gmail.com");
    }

    @Test
    public void testSendWithAttachment() {
        emailService.sendWithAttachment("lanrenguo@gmail.com");
    }
}
