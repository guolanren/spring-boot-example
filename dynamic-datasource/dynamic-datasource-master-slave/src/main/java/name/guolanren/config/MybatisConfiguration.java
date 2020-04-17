package name.guolanren.config;

import com.baomidou.dynamic.datasource.plugin.MasterSlaveAutoRoutingPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guolanren
 */
@Configuration
@MapperScan("name.guolanren.mapper")
public class MybatisConfiguration {

    /**
     * 场景：
     *      1. 在纯的读写分离环境，写操作全部是master，读操作全部是slave。
     *      2. 不想通过注解配置完成以上功能。
     * 答：
     *      在mybatis环境下可以基于mybatis插件结合本数据源完成以上功能。 手动注入插件。
     *
     * 默认主库名称master,从库名称slave。
     */
    @Bean
    public MasterSlaveAutoRoutingPlugin masterSlaveAutoRoutingPlugin(){
        return new MasterSlaveAutoRoutingPlugin();
    }

}
