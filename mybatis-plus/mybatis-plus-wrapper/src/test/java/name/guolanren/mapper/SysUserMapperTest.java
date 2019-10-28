package name.guolanren.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import name.guolanren.model.SysUser;
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
    private SysUserMapper sysUserMapper;

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod1() {
        SysUser beforeDelete = sysUserMapper.selectById(1L);
        assertNotNull(beforeDelete);

        QueryWrapper<SysUser> wrapper = Wrappers.query();
        wrapper.eq("sys_user_id", 1L);
        int deletedRows = sysUserMapper.delete(wrapper);
        assertTrue(deletedRows > 0);

        SysUser afterDelete = sysUserMapper.selectById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteMethod2() {
        SysUser beforeDelete = sysUserMapper.selectById(1L);
        assertNotNull(beforeDelete);

        int deletedRows = sysUserMapper.delete(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getId, 1L));
        assertTrue(deletedRows > 0);

        SysUser afterDelete = sysUserMapper.selectById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod1() {
        SysUser beforeUpdate = sysUserMapper.selectById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        UpdateWrapper<SysUser> wrapper = Wrappers.update();
        wrapper
                .set("name", "guolanren")
                .eq("sys_user_id", 1L);
        sysUserMapper.update(null, wrapper);

        SysUser afterUpdate = sysUserMapper.selectById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateMethod2() {
        SysUser beforeUpdate = sysUserMapper.selectById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        sysUserMapper.update(null, Wrappers.<SysUser>lambdaUpdate()
                .set(SysUser::getName, "guolanren")
                .eq(SysUser::getId, 1L));

        SysUser afterUpdate = sysUserMapper.selectById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }
}
