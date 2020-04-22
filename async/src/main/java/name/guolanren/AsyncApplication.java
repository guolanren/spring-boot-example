package name.guolanren;

import name.guolanren.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;

/**
 * @author guolanren
 */
@SpringBootApplication
public class AsyncApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AsyncApplication.class);

    @Autowired
    private AsyncService asyncService;

    private CompletableFuture<String>[] futures = new CompletableFuture[3];

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        futures[0] = asyncService.nameToUpperCase("guolanren");
        futures[1] = asyncService.nameToUpperCase("guoyaozhan");
        futures[2] = asyncService.nameToUpperCase("genius");

        CompletableFuture.allOf(futures).join();

        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info(futures[0].get());
        logger.info(futures[1].get());
        logger.info(futures[2].get());
    }
}
