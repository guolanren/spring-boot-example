package name.guolanren.mapper;

import name.guolanren.model.SysUser;
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
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    @Transactional
    @Rollback
    public void testMapperInsert() {
        SysUser sysUser = new SysUser();
        sysUser.setName("guolanren");

        int insertedRows = sysUserMapper.insert(sysUser);
        assertTrue(insertedRows > 0);
        assertEquals(4, sysUser.getId().longValue());

        System.out.println(sysUser);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperDeleteById() {
        SysUser beforeDelete = sysUserMapper.selectById(1L);
        assertNotNull(beforeDelete);

        int deletedRows = sysUserMapper.deleteById(1L);
        assertTrue(deletedRows > 0);

        SysUser afterDelete = sysUserMapper.selectById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testMapperUpdateById() {
        SysUser beforeUpdate = sysUserMapper.selectById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        SysUser updateModel = new SysUser();
        updateModel.setId(1L);
        updateModel.setName("guolanren");
        sysUserMapper.updateById(updateModel);

        SysUser afterUpdate = sysUserMapper.selectById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    public void testMapperSelectById() {
        SysUser sysUser = sysUserMapper.selectById(1L);
        assertNotNull(sysUser);
        assertEquals("甲", sysUser.getName());
    }
}
