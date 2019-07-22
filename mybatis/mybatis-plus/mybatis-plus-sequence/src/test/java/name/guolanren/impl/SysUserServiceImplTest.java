package name.guolanren.impl;

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
        assertTrue(sysUser.getId().equals("1"));
    }

}
