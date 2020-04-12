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
public class RocketMQSendApplication implements CommandLineRunner {

	@Autowired
	private OrderPaidService orderPaidService;

	public static void main(String[] args) {
		SpringApplication.run(RocketMQSendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
//			orderPaidService.springMessageSend();
//			orderPaidService.springMessageConvertAndSend();
//			orderPaidService.syncSend();
			orderPaidService.asyncSend();
//			orderPaidService.syncSendOrderly();
		} finally {
			orderPaidService.close();
		}
	}
}
