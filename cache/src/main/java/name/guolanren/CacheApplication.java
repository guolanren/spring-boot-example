package name.guolanren;

import name.guolanren.model.CacheUser;
import name.guolanren.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

/**
 * @author guolanren
 */
@SpringBootApplication
public class CacheApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CacheApplication.class);

    private long start;

    @Autowired
    private CacheService cacheService;

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("添加数据");
        cacheService.add(new CacheUser(1L, "guolanren"));
        logger.info("=================================");

        logger.info("第一次查询，缓存结果");
        start = System.currentTimeMillis();
        CacheUser user = cacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
        logger.info("=================================");


        logger.info("缓存命中");
        start = System.currentTimeMillis();
        user = cacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
        logger.info("=================================");

        logger.info("更新数据，更新缓存");
        cacheService.update(new CacheUser(1L, "guoyaozhan"));
        logger.info("=================================");

        logger.info("缓存命中");
        start = System.currentTimeMillis();
        user = cacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
        logger.info("=================================");

        logger.info("删除数据，删除缓存");
        cacheService.delete(1L);
        logger.info("=================================");

        logger.info("重新查询");
        start = System.currentTimeMillis();
        user = cacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
    }

}
