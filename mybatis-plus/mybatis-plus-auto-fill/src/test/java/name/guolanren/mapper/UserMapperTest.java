package name.guolanren.mapper;

import name.guolanren.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author guolanren
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    @Rollback
    public void testMapperInsert() {
        User user = new User();
        user.setName("guolanren");

        userMapper.insert(user);

        assertEquals(1, user.getId().longValue());
        assertNotNull(user.getCreateTime());
        assertNotNull(user.getUpdateTime());
        assertEquals(user.getCreateTime(), user.getUpdateTime());

        user.setName("guoyaozhan");
        userMapper.updateById(user);

        assertEquals(1, user.getId().longValue());
        assertNotNull(user.getCreateTime());
        assertNotNull(user.getUpdateTime());
        assertNotEquals(user.getCreateTime(), user.getUpdateTime());
    }

}
