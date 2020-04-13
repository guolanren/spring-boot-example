package name.guolanren.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author guolanren
 */
@Service
public class AsyncService {

    @Async("asyncExecutor")
    public CompletableFuture<String> nameToUpperCase(String name) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(Thread.currentThread().getName() + ": " + name.toUpperCase());
    }

}
