package name.guolanren.service;

import name.guolanren.model.OrderPaidEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author guolanren
 */
@Service
public class OrderPaidService {

    private static final Logger logger = LoggerFactory.getLogger(OrderPaidService.class);

    public static final String MY_TOPIC = "my-topic";

    public static final AtomicLong ORDER_ID = new AtomicLong(0);

    @Autowired
    private KafkaTemplate<String, OrderPaidEvent> kafka;

    public void send() {
        ListenableFuture<SendResult<String, OrderPaidEvent>> result = kafka.send(MY_TOPIC,
                new OrderPaidEvent(String.valueOf(ORDER_ID.incrementAndGet()), new BigDecimal(100.0)));
        result.addCallback(new ResultHandle());
    }

    public void sendDefault() {
        ListenableFuture<SendResult<String, OrderPaidEvent>> result = kafka.sendDefault(new OrderPaidEvent(String.valueOf(ORDER_ID.incrementAndGet()), new BigDecimal(100.0)));
        result.addCallback(new ResultHandle());
    }

    private class ResultHandle<T> implements ListenableFutureCallback<T> {

        @Override
        public void onFailure(Throwable ex) {
            logger.debug("MQ推送消息失败: {}", ex.getMessage());
        }

        @Override
        public void onSuccess(T result) {
            logger.info("MQ推送消息成功: {}", result);
        }
    }
}
