package name.guolanren.service;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author guolanren
 */
@Service
public class TransactionalProducer implements Closeable {

    public static final String MY_TRANSACTIONAL_TOPIC = "my-transactional-topic";

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendInTransaction() {
        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {
                Message msg = MessageBuilder
                        .withPayload("Hello World at " + System.currentTimeMillis())
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, "KEY_" + i)
                        .build();
                TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(
                        MY_TRANSACTIONAL_TOPIC + ":" + tags[i % tags.length], msg, null);
                System.out.printf("------rocketMQTemplate send Transactional msg body = %s , sendResult=%s %n",
                        msg.getPayload(), sendResult.getSendStatus());

                TimeUnit.MILLISECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws IOException {
        rocketMQTemplate.destroy();
    }
}
