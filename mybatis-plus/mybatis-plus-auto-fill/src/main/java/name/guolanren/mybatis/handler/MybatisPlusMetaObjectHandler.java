package name.guolanren.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author guolanren
 */
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static final Logger logger = LoggerFactory.getLogger(MybatisPlusMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        // Insert: 创建时间
        logger.debug("insert fill createTime");
        this.setFieldValByName("createTime", new Date(), metaObject);

        // Insert: 更新时间
        logger.debug("insert fill updateTime");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // Update: 更新时间
        logger.debug("update fill updateTime");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
