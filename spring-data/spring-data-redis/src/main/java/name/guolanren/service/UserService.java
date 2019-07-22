package name.guolanren.service;

import name.guolanren.entity.User;
import name.guolanren.repository.UserRepository;
import name.guolanren.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author guolanren
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOperations;

    public List<User> getAllByRestTemplate() {
        List<User> usersInRedis = (List<User>) redisTemplate.opsForValue().get("users");
        if (usersInRedis != null) {
            return usersInRedis;
        }
        List<User> usersInDB = userRepository.findAll();
        redisTemplate.opsForValue().set("users", usersInDB);
        return usersInDB;
    }

    public List<User> getAllByValueOperations() {
        List<User> usersInRedis = (List<User>) valueOperations.get("users");
        if (usersInRedis != null) {
            return usersInRedis;
        }
        List<User> usersInDB = userRepository.findAll();
        valueOperations.set("users", usersInDB);
        return usersInDB;
    }

    @Cacheable
    public User getById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    @CachePut(key = "#user.id")
    public User update(User user) {
        User userInDB = userRepository.findById(user.getId()).get();
        BeanUtils.copyProperties(user, userInDB, BeanUtil.getNullFieldNames(user));
        return userRepository.save(userInDB);
    }

    @CacheEvict
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
