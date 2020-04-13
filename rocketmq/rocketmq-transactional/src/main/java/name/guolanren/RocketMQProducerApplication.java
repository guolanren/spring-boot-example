package name.guolanren;

import name.guolanren.service.TransactionalProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
public class RocketMQProducerApplication implements CommandLineRunner {

	@Autowired
	private TransactionalProducer transactionalProducer;

	public static void main(String[] args) {
		SpringApplication.run(RocketMQProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			transactionalProducer.sendInTransaction();
		} finally {
			transactionalProducer.close();
		}
	}
}
