package name.guolanren.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.PoolException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author guolanren
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(CacheProperties.class)
public class RedisConfiguration extends CachingConfigurerSupport {

    public static final Logger LOG = LoggerFactory.getLogger(RedisConfiguration.class);

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheManager redisCacheManager = RedisCacheManager.RedisCacheManagerBuilder
//                .fromConnectionFactory(redisConnectionFactory).build();
//        return redisCacheManager;
//    }


    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                if (e instanceof PoolException) {
                    LOG.error(e.getMessage());
                } else {
                    throw e;
                }
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
                if (e instanceof PoolException) {
                    LOG.error(e.getMessage());
                } else {
                    throw e;
                }
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
                if (e instanceof PoolException) {
                    LOG.error(e.getMessage());
                } else {
                    throw e;
                }
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                if (e instanceof PoolException) {
                    LOG.error(e.getMessage());
                } else {
                    throw e;
                }
            }
        };
    }

}
