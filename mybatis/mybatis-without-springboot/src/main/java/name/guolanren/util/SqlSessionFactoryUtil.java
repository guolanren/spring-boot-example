package name.guolanren.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guolanren
 */
public class SqlSessionFactoryUtil {

    private static final transient ReentrantLock lock = new ReentrantLock();

    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryUtil() {}

    private static SqlSessionFactory initSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            final ReentrantLock lock = SqlSessionFactoryUtil.lock;
            lock.lock();
            try {
                if (sqlSessionFactory == null) {
                    String resource = "mybatis/config/mybatis-config.xml";
                    sqlSessionFactory = new SqlSessionFactoryBuilder()
                            .build(Resources.getResourceAsStream(resource));
                    return sqlSessionFactory;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
