package name.guolanren;

import name.guolanren.service.OrderPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
public class RocketMQConsumerApplication implements CommandLineRunner {

	@Autowired
	private OrderPaidService orderPaidService;

	public static void main(String[] args) {
		SpringApplication.run(RocketMQConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//			orderPaidService.springMessageSend();
//			orderPaidService.springMessageConvertAndSend();
//			orderPaidService.syncSend();
//			orderPaidService.asyncSend();
//			orderPaidService.syncSendOrderly();
	}
}
