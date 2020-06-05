package name.guolanren.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import name.guolanren.model.JetCacheUser;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author guolanren
 */
@Service
public class JetCacheService {

    private ConcurrentHashMap<Long, JetCacheUser> store = new ConcurrentHashMap<>();

    public void add(JetCacheUser user) {
        store.put(user.getId(), user);
    }

    @Cached(name = "CacheService.get:", key = "#id", expire = 3600)
    public JetCacheUser get(Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return store.getOrDefault(id, new JetCacheUser(0L, "none"));
    }

    @CacheUpdate(name = "CacheService.get:", key = "#user.id", value = "#result")
    public JetCacheUser update(JetCacheUser user) {
        store.put(user.getId(), user);
        return user;
    }

    @CacheInvalidate(name = "CacheService.get:", key="#id")
    public void delete(Long id) {
        store.remove(id);
    }
}
