package name.guolanren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
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
    private SysUserService sysUserService;

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod1() {
        SysUser beforeDelete = sysUserService.getById(1L);
        assertNotNull(beforeDelete);

        QueryWrapper<SysUser> wrapper = Wrappers.query();
        wrapper.eq("sys_user_id", 1L);
        boolean isDeleted = sysUserService.remove(wrapper);
        assertTrue(isDeleted);

        SysUser afterDelete = sysUserService.getById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod2() {
        SysUser beforeDelete = sysUserService.getById(1L);
        assertNotNull(beforeDelete);

        boolean isDeleted = sysUserService.remove(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getId, 1L));
        assertTrue(isDeleted);

        SysUser afterDelete = sysUserService.getById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod1() {
        SysUser beforeUpdate = sysUserService.getById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        UpdateWrapper<SysUser> wrapper = Wrappers.update();
        wrapper
                .set("name", "guolanren")
                .eq("sys_user_id", 1L);
        sysUserService.update(null, wrapper);

        SysUser afterUpdate = sysUserService.getById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod2() {
        SysUser beforeUpdate = sysUserService.getById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        sysUserService.update(null, Wrappers.<SysUser>lambdaUpdate()
                .set(SysUser::getName, "guolanren")
                .eq(SysUser::getId, 1L));

        SysUser afterUpdate = sysUserService.getById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }
}
