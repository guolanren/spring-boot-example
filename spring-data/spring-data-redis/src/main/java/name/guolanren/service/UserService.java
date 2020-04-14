package name.guolanren.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author guolanren
 */
@Service
public class UserService {

    public static final String KEY_PREFIX = "spring:data:redis";

    @Autowired
    private RedisTemplate<String, Object> redis;

    public void ttl() {
        redis.boundValueOps(KEY_PREFIX + UUID.randomUUID())
                .set("Hello World!", 30, TimeUnit.MINUTES);
    }

}
