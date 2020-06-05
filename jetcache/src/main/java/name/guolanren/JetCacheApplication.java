package name.guolanren;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import name.guolanren.model.JetCacheUser;
import name.guolanren.service.JetCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "name.guolanren")
public class JetCacheApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(JetCacheApplication.class);

    private long start;

    @Autowired
    private JetCacheService jetCacheService;

    public static void main(String[] args) {
        SpringApplication.run(JetCacheApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("添加数据");
        jetCacheService.add(new JetCacheUser(1L, "guolanren"));
        logger.info("=================================");

        logger.info("第一次查询，缓存结果");
        start = System.currentTimeMillis();
        JetCacheUser user = jetCacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
        logger.info("=================================");


        logger.info("缓存命中");
        start = System.currentTimeMillis();
        user = jetCacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
        logger.info("=================================");

        logger.info("更新数据，更新缓存");
        jetCacheService.update(new JetCacheUser(1L, "guoyaozhan"));
        logger.info("=================================");

        logger.info("缓存命中");
        start = System.currentTimeMillis();
        user = jetCacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
        logger.info("=================================");

        logger.info("删除数据，删除缓存");
        jetCacheService.delete(1L);
        logger.info("=================================");

        logger.info("重新查询");
        start = System.currentTimeMillis();
        user = jetCacheService.get(1L);
        logger.info("use time: {}, data: {}", System.currentTimeMillis() - start, user.toString());
    }

}
