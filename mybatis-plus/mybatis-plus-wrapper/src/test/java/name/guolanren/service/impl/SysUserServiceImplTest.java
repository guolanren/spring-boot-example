package name.guolanren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
public class SysUserServiceImplTest {

    @Autowired
    private UserService sysUserService;

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod1() {
        User beforeDelete = sysUserService.getById(1L);
        assertNotNull(beforeDelete);

        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("sys_user_id", 1L);
        boolean isDeleted = sysUserService.remove(wrapper);
        assertTrue(isDeleted);

        User afterDelete = sysUserService.getById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod2() {
        User beforeDelete = sysUserService.getById(1L);
        assertNotNull(beforeDelete);

        boolean isDeleted = sysUserService.remove(Wrappers.<User>lambdaQuery().eq(User::getId, 1L));
        assertTrue(isDeleted);

        User afterDelete = sysUserService.getById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod1() {
        User beforeUpdate = sysUserService.getById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        UpdateWrapper<User> wrapper = Wrappers.update();
        wrapper
                .set("name", "guolanren")
                .eq("sys_user_id", 1L);
        sysUserService.update(null, wrapper);

        User afterUpdate = sysUserService.getById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod2() {
        User beforeUpdate = sysUserService.getById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        sysUserService.update(null, Wrappers.<User>lambdaUpdate()
                .set(User::getName, "guolanren")
                .eq(User::getId, 1L));

        User afterUpdate = sysUserService.getById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }
}
