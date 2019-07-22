package name.guolanren.service.impl;

import freemarker.template.Template;
import name.guolanren.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guolanren
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private FreeMarkerConfigurer configurer;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(String who) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(who);
        message.setSubject("Spring Email Test");
        message.setText("Hello Email");
        mailSender.send(message);
    }

    @Override
    public void sendWithAttachment(String who) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(who);
            mimeMessageHelper.setSubject("Spring Email Test");
            mimeMessageHelper.setText("Hello Email");
            mimeMessageHelper.addAttachment("email/email.ftl", new ClassPathResource("email/email.ftl"));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendByHTML(String who) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(who);
            mimeMessageHelper.setSubject("Spring Email Test");

            Map<String, Object> module = new HashMap<>(1);
            module.put("who", who);

            try {
                Template template = configurer.getConfiguration().getTemplate("email.ftl");
                mimeMessageHelper.setText(FreeMarkerTemplateUtils.processTemplateIntoString(template, module), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
