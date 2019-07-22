package name.guolanren.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author guolanren
 */
@Intercepts({
    @Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
    )
})
public class AuditingInterceptor implements Interceptor {

    private final Logger logger = LoggerFactory.getLogger(AuditingInterceptor.class);

    private static final String CREATE_PROPERTY_NAME = "createdPropertyName";
    private static final String MODIFIED_PROPERTY_NAME = "modifiedPropertyName";
    private static final String DEFAULT_CREATE_PROPERTY = "gmtCreate";
    private static final String DEFAULT_MODIFIED_PROPERTY = "gmtModified";
    private String createProperty;
    private String modifiedProperty;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        SqlCommandType sqlCommandType = statement.getSqlCommandType();

        if (parameter instanceof Collection) {
            Iterator iterator = ((Collection) parameter).iterator();
            while (iterator.hasNext()) {
                auditingParameter(sqlCommandType, iterator.next());
            }
        } else {
            auditingParameter(sqlCommandType, parameter);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        this.createProperty = properties.getProperty(CREATE_PROPERTY_NAME, DEFAULT_CREATE_PROPERTY);
        this.modifiedProperty = properties.getProperty(MODIFIED_PROPERTY_NAME, DEFAULT_MODIFIED_PROPERTY);
    }

    private void auditingParameter(SqlCommandType sqlCommandType, Object parameter) {
        Date date = new Date(System.currentTimeMillis());
        switch (sqlCommandType) {
            case INSERT: {
                insert(parameter, date);
                break;
            }
            case UPDATE: {
                update(parameter, date);
                break;
            }
            default:
                logger.warn("auditing failed: Invalid execution method for {}", sqlCommandType.name());
        }
    }

    private void insert(Object o, Date date) {
        try {
            Field createField = o.getClass().getDeclaredField(createProperty);
            createField.setAccessible(true);
            createField.set(o, date);

            Field modifiedField = o.getClass().getDeclaredField(modifiedProperty);
            modifiedField.setAccessible(true);
            modifiedField.set(o, date);
        } catch (Exception e) {
            logger.warn("auditing failed while executing insert statement: {}", e.getMessage());
        }
    }

    private void update(Object o, Date date) {
        try {
            Field modifiedField = o.getClass().getDeclaredField(modifiedProperty);
            modifiedField.setAccessible(true);
            modifiedField.set(o, date);
        } catch (Exception e) {
            logger.warn("auditing failed while executing update statement: {}", e.getMessage());
        }
    }
}
