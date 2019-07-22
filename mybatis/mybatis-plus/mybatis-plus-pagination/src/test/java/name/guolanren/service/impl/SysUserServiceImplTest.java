package name.guolanren.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testServicePage() throws JsonProcessingException {
        IPage<SysUser> sysUsersPage = sysUserService.page(new Page<>(2,2));
        assertNotNull(sysUsersPage);
        assertEquals(3, sysUsersPage.getTotal());
        assertEquals(2, sysUsersPage.getCurrent());
        assertEquals(2, sysUsersPage.getSize());

        System.out.println(new ObjectMapper().writeValueAsString(sysUsersPage));
    }
}
