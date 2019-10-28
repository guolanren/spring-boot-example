package name.guolanren;

import name.guolanren.dao.UserMapper;
import name.guolanren.model.User;
import name.guolanren.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author guolanren
 */
public class MybatisWithoutSpringBootApplication {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getById(1L);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

}
