package name.guolanren.service;

import name.guolanren.model.CacheUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author guolanren
 */
@Service
@CacheConfig(cacheNames = {"spring:cache:name"})
public class CacheService {

    private ConcurrentHashMap<Long, CacheUser> store = new ConcurrentHashMap<>();

    public void add(CacheUser user) {
        store.put(user.getId(), user);
    }

    @Cacheable(key = "#id", condition = "#id != null", sync = true)
    public CacheUser get(Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return store.getOrDefault(id, new CacheUser(0L, "none"));
    }

    @CachePut(key = "#user.id")
    public CacheUser update(CacheUser user) {
        store.put(user.getId(), user);
        return user;
    }

    @CacheEvict(key = "#id")
    public void delete(Long id) {
        store.remove(id);
    }
}
