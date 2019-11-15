package name.guolanren.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import name.guolanren.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author guolanren
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserMapperTest {

    @Autowired
    private UserMapper sysUserMapper;

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod1() {
        User beforeDelete = sysUserMapper.selectById(1L);
        assertNotNull(beforeDelete);

        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("sys_user_id", 1L);
        int deletedRows = sysUserMapper.delete(wrapper);
        assertTrue(deletedRows > 0);

        User afterDelete = sysUserMapper.selectById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod2() {
        User beforeDelete = sysUserMapper.selectById(1L);
        assertNotNull(beforeDelete);

        int deletedRows = sysUserMapper.delete(Wrappers.<User>lambdaQuery().eq(User::getId, 1L));
        assertTrue(deletedRows > 0);

        User afterDelete = sysUserMapper.selectById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod1() {
        User beforeUpdate = sysUserMapper.selectById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        UpdateWrapper<User> wrapper = Wrappers.update();
        wrapper
                .set("name", "guolanren")
                .eq("sys_user_id", 1L);
        sysUserMapper.update(null, wrapper);

        User afterUpdate = sysUserMapper.selectById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod2() {
        User beforeUpdate = sysUserMapper.selectById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        sysUserMapper.update(null, Wrappers.<User>lambdaUpdate()
                .set(User::getName, "guolanren")
                .eq(User::getId, 1L));

        User afterUpdate = sysUserMapper.selectById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

}
