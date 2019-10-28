package name.guolanren.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import name.guolanren.model.SysUser;
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
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testMapperSelectPage() throws JsonProcessingException {
        IPage<SysUser> sysUsersPage = sysUserMapper.selectPage(new Page<>(2,2), Wrappers.emptyWrapper());
        assertNotNull(sysUsersPage);
        assertEquals(3, sysUsersPage.getTotal());
        assertEquals(2, sysUsersPage.getCurrent());
        assertEquals(2, sysUsersPage.getSize());

        System.out.println(new ObjectMapper().writeValueAsString(sysUsersPage));
    }

    @Test
    public void testFindPageXmlCustomize() throws JsonProcessingException {
        IPage<SysUser> sysUsers = sysUserMapper.findPageXmlCustomize(new Page(2,2), "甲");
        assertNotNull(sysUsers);

        System.out.println(new ObjectMapper().writeValueAsString(sysUsers));
    }
}
