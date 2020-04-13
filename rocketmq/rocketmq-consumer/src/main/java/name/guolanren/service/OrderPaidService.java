package name.guolanren.service;

import name.guolanren.model.OrderPaidEvent;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class OrderPaidService {

    private static final Logger logger = LoggerFactory.getLogger(OrderPaidService.class);

    @Service
    @RocketMQMessageListener(topic = "my-topic", consumerGroup = "my-topic-group" /* , accessKey = "AK", secretKey = "SK" */)
    public class StringConsumer implements RocketMQListener<String>{
        @Override
        public void onMessage(String message) {
            logger.info("received message: {}", message);
        }
    }

    @Service
    @RocketMQMessageListener(topic = "my-topic", consumerGroup = "my-topic-group")
    public class OrderPaidEventConsumer implements RocketMQListener<OrderPaidEvent>{
        @Override
        public void onMessage(OrderPaidEvent orderPaidEvent) {
            logger.info("received orderPaidEvent: {}", orderPaidEvent);
        }
    }
}
