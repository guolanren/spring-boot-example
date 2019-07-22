package name.guolanren.service.impl;

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
    public void testServiceSave() {
        SysUser sysUser = new SysUser();
        sysUser.setName("guolanren");

        boolean success = sysUserService.save(sysUser);
        assertTrue(success);
        assertEquals(4, sysUser.getId().longValue());

        System.out.println(sysUser);
    }

    @Test
    @Transactional
    @Rollback
    public void testServiceRemoveById() {
        SysUser beforeDelete = sysUserService.getById(1L);
        assertNotNull(beforeDelete);

        boolean success = sysUserService.removeById(1L);
        assertTrue(success);

        SysUser afterDelete = sysUserService.getById(1L);
        assertNull(afterDelete);
    }

    @Test
    @Transactional
    @Rollback
    public void testServiceUpdateById() {
        SysUser beforeUpdate = sysUserService.getById(1L);
        assertNotNull(beforeUpdate);
        assertEquals("甲", beforeUpdate.getName());

        SysUser updateModel = new SysUser();
        updateModel.setId(1L);
        updateModel.setName("guolanren");
        sysUserService.updateById(updateModel);

        SysUser afterUpdate = sysUserService.getById(1L);
        assertNotNull(afterUpdate);
        assertEquals("guolanren", afterUpdate.getName());
    }

    @Test
    public void testServiceSelectById() {
        SysUser sysUser = sysUserService.getById(1L);
        assertNotNull(sysUser);
        assertEquals("甲", sysUser.getName());
    }
}
