package name.guolanren.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @author guolanren
 */
@Service
public class SpecifiedOffsetOrderPaidService implements MessageListenerConcurrently {

    @Value("${rocketmq.name-server}")
    private String nameServer;

    private static final Logger logger = LoggerFactory.getLogger(SpecifiedOffsetOrderPaidService.class);

    private final DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-topic-group");

    @PostConstruct
    public void start() {
        try {
            logger.info("启动消费者...");
            consumer.setNamesrvAddr(nameServer);
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            consumer.setMessageModel(MessageModel.CLUSTERING);
            consumer.subscribe("my-topic", "*");
            consumer.registerMessageListener(this);
            consumer.start();
        } catch (MQClientException e) {
            logger.error("启动消费者失败...", e);
        }
    }


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        try {
            for (int i = 0; i < msgs.size(); i++) {
                String message = new String(msgs.get(i).getBody(), RemotingHelper.DEFAULT_CHARSET);
                logger.info("received message: {}", message);
            }
        } catch (Exception e) {
            logger.error("消费者消费失败...", e);
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    @PreDestroy
    public void close() {
        if (consumer != null) {
            logger.info("关闭消费者...");
            consumer.shutdown();
        }
    }
}
