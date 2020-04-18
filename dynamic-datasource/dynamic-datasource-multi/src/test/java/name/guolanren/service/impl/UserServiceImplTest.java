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
    public void testInsert() {
        User user = new User();
        user.setName("guolanren");
        user.setAge(0);

        Long rows = userService.insert(user);
        assertEquals(1L, rows.longValue());

        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("g0");
        user.setAge(0);

        Long rows = userService.update(user);
        assertEquals(1L, rows.longValue());

        System.out.println(user);
    }

    @Test
    public void testDelete() {
        Long rows = userService.delete(1L);
        assertEquals(1L, rows.longValue());
    }

    @Test
    public void testGet() {
        System.out.println(userService.get(1L));
    }

    @Test
    public void testGetAll() {
        System.out.printf("第一次获取：%s", userService.getAll());
        System.out.printf("第二次获取：%s", userService.getAll());
    }
}
