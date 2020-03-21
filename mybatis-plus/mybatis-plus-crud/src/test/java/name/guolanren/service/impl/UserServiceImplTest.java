package name.guolanren.service.impl;

import name.guolanren.model.User;
import name.guolanren.service.UserService;
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
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    @Rollback
    public void testServiceSave() {
        User user = new User();
        user.setName("guolanren");

        boolean success = userService.save(user);
        assertTrue(success);
        assertEquals(4, user.getId().longValue());

        System.out.println(user);
    }

    @Test
    @Transactional
    @Rollback
    public void testServiceRemoveById() {
        User beforeDelete = userService.getById(1L);
        assertNotNull(beforeDelete);

        boolean success = userService.removeById(1L);
        assertTrue(success);

        User afterDelete = userService.getById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testServiceUpdateById() {
        User beforeUpdate = userService.getById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        User updateModel = new User();
        updateModel.setId(1L);
        updateModel.setName("guolanren");
        userService.updateById(updateModel);

        User afterUpdate = userService.getById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    public void testServiceSelectById() {
        User user = userService.getById(1L);
        assertNotNull(user);
        assertEquals("甲", user.getName());
    }
}
