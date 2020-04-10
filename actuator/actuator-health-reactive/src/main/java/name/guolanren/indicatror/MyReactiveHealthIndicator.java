package name.guolanren.indicatror;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * @author guolanren
 */
@Component
public class MyReactiveHealthIndicator implements ReactiveHealthIndicator {

    @Override
    public Mono<Health> health() {
        //perform some specific health check that returns a Mono<Health>
        return doHealthCheck(new Health.Builder())
                .onErrorResume(ex -> Mono.just(new Health.Builder().down(ex).build()));
    }

    private Mono<Health> doHealthCheck(Health.Builder builder) {
        return Mono.fromSupplier(() -> {
            int errorCode = check();
            if (errorCode != 0) {
                return Health.down().withDetail("Error Code", errorCode).build();
            }
            return Health.up().build();
        });
    }

    public int check() {
        return new Random().nextInt(2);
    }
}
