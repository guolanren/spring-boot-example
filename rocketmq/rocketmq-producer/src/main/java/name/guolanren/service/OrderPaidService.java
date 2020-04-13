package name.guolanren.service;

import name.guolanren.model.OrderPaidEvent;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author guolanren
 */
@Service
public class OrderPaidService implements Closeable {

    private static final Logger logger = LoggerFactory.getLogger(OrderPaidService.class);

    public static final String MY_TOPIC = "my-topic";

    public static final String MY_ORDERLY_TOPIC = "my-orderly-topic";

    public static final AtomicLong ORDER_ID = new AtomicLong(0);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void springMessageSend() {
        while (true) {
            rocketMQTemplate.send(MY_TOPIC,
                    MessageBuilder
                            .withPayload("Hello World at " + System.currentTimeMillis())
                            .build());
        }
    }

    public void springMessageConvertAndSend() {
        while (true) {
            rocketMQTemplate.convertAndSend(MY_TOPIC,
                    MessageBuilder
                            .withPayload("Hello World  at " + System.currentTimeMillis())
                            .build());
        }
    }

    public void syncSend() {
        while (true) {
            SendResult result = rocketMQTemplate.syncSend(MY_TOPIC,
                    MessageBuilder.withPayload("Hello World  at " + System.currentTimeMillis()).build());
            switch (result.getSendStatus()) {
                case SEND_OK:
                    logger.debug(Thread.currentThread().getName() + ": 发送消息成功!" );
                    break;
                case FLUSH_DISK_TIMEOUT:
                    logger.error(Thread.currentThread().getName() + ": 发送消息失败 -> 响应超时..." );
                    break;
                case FLUSH_SLAVE_TIMEOUT:
                    logger.warn(Thread.currentThread().getName() + ": slave 同步消息失败 -> 响应超时..." );
                    break;
                case SLAVE_NOT_AVAILABLE:
                    logger.warn(Thread.currentThread().getName() + ": slave 同步消息失败 -> 找不到 slave..." );
                    break;
                default:
            }
        }
    }

    public void asyncSend() {
        while (true) {
            rocketMQTemplate.asyncSend(MY_TOPIC,
                    new OrderPaidEvent("ORDER_" + ORDER_ID.getAndIncrement(), new BigDecimal("88.00")),
                    new SendCallback() {
                        @Override
                        public void onSuccess(SendResult result) {
                            logger.debug("async onSuccess SendResult={}", result);
                        }

                        @Override
                        public void onException(Throwable t) {
                            logger.error("async onException", t);
                        }
                    });
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncSendOrderly() {
        while (true) {
            rocketMQTemplate.syncSendOrderly(MY_ORDERLY_TOPIC,
                    MessageBuilder
                            .withPayload(new OrderPaidEvent("ORDER_" + ORDER_ID.getAndIncrement(), new BigDecimal("88.00")))
                            .build(),
                    "hash-key");
        }
    }

    @Override
    public void close() throws IOException {
        rocketMQTemplate.destroy();
    }
}
