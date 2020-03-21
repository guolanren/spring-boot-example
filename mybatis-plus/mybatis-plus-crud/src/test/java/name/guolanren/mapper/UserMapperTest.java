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

        int insertedRows = userMapper.insert(user);
        assertTrue(insertedRows > 0);
        assertEquals(4, user.getId().longValue());

        System.out.println(user);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteById() {
        User beforeDelete = userMapper.selectById(1L);
        assertNotNull(beforeDelete);

        int deletedRows = userMapper.deleteById(1L);
        assertTrue(deletedRows > 0);

        User afterDelete = userMapper.selectById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateById() {
        User beforeUpdate = userMapper.selectById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        User updateModel = new User();
        updateModel.setId(1L);
        updateModel.setName("guolanren");
        userMapper.updateById(updateModel);

        User afterUpdate = userMapper.selectById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    public void testMapperSelectById() {
        User user = userMapper.selectById(1L);
        assertNotNull(user);
        assertEquals("甲", user.getName());
    }
}
