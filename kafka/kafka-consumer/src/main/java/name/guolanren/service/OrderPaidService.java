package name.guolanren.service;

import name.guolanren.model.OrderPaidEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class OrderPaidService {

    private static final Logger logger = LoggerFactory.getLogger(OrderPaidService.class);

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void handle(OrderPaidEvent orderPaidEvent) {
        logger.info("received orderPaidEvent: {}", orderPaidEvent);
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void handleRecord(ConsumerRecord<String, OrderPaidEvent> orderPaidEventRecord) {
        logger.info("received orderPaidEvent header: {}", orderPaidEventRecord.headers());
        logger.info("received orderPaidEvent payload: {}", orderPaidEventRecord.value());
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void handleMessage(Message<OrderPaidEvent> orderPaidEventMessage) {
        logger.info("received orderPaidEvent header: {}", orderPaidEventMessage.getHeaders());
        logger.info("received orderPaidEvent payload: {}", orderPaidEventMessage.getPayload());
    }
}
