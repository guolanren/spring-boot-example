package name.guolanren.service.impl;

import com.github.pagehelper.PageInfo;
import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guolanren
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserServiceImplTest {

    @Autowired
    protected SysUserService sysUserService;

    @Test
    @Transactional
    @Rollback
    public void testSearch() {
        PageInfo<SysUser> sysUserPageInfo = sysUserService.search(1, 2);
        Assert.assertEquals(2, sysUserPageInfo.getList().size());

        sysUserPageInfo.getList().stream().forEach(sysUser -> System.out.println(sysUser));
    }

}