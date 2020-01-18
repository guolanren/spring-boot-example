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
        User user = userMapper.selectById(1L);
        assertNotNull(user);
        assertEquals(false, user.getDeleted());

        userMapper.deleteById(user.getId());
        User afterDelete = userMapper.selectById(1L);
        assertNull(afterDelete);
    }

}
