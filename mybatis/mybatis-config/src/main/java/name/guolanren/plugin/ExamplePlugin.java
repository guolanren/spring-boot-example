package name.guolanren.plugin;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;
import java.util.concurrent.Executor;

@Intercepts({@Signature(
  type= Executor.class,
  method = "update",
  args = {MappedStatement.class,Object.class})})
public class ExamplePlugin implements Interceptor {

  private Properties properties = new Properties();

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    // implement pre processing if need
    Object returnObject = invocation.proceed();
    // implement post processing if need
    return returnObject;
  }

    @Override
    public Object plugin(Object o) {
        if (o instanceof org.apache.ibatis.executor.Executor) {
            return Plugin.wrap(o, this);
        }
        return o;
    }

    @Override
  public void setProperties(Properties properties) {
    this.properties = properties;
  }

}