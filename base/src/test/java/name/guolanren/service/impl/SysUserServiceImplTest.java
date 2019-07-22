package name.guolanren.service.impl;

import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException expectionRule = ExpectedException.none();

    @Test
    @Transactional
    @Rollback
    public void testCreate() {
        // 创建前
        Assert.assertFalse(sysUserService.exists(4L));

        // 创建
        SysUser sysUser = new SysUser();
        sysUser.setName("");
        sysUserService.create(sysUser);

        // 创建后
        Assert.assertTrue(sysUserService.exists(4L));
    }

    @Test
    @Transactional
    @Rollback
    public void testRemove() {
        // 删除前
        SysUser beforeRemove = sysUserService.getById(1L);
        Assert.assertNotNull(beforeRemove);

        // 删除
        sysUserService.remove(1L);

        // 删除后
        SysUser afterRemove = sysUserService.getById(1L);
        Assert.assertNull(afterRemove);
    }

    @Test
    @Transactional
    @Rollback
    public void testModify() {
        // 修改前
        SysUser beforeModify = sysUserService.getById(1L);
        Assert.assertEquals("甲", beforeModify.getName());

        // 修改
        SysUser sysUser = new SysUser();
        sysUser.setSysUserId(1L);
        sysUser.setName("丁");
        sysUserService.modify(sysUser);

        // 修改后
        SysUser afterModify = sysUserService.getById(1L);
        Assert.assertEquals("丁", afterModify.getName());
    }

    @Test
    public void testGetById() {
        SysUser sysUser = sysUserService.getById(1L);
        Assert.assertEquals("甲", sysUser.getName());

        Assert.assertNull(sysUserService.getById(4L));
    }

    @Test
    public void testExists() {
        Assert.assertTrue(sysUserService.exists(1L));
        Assert.assertFalse(sysUserService.exists(4L));
    }

//    @Test
//    public void testLoginSuccess() {
//        SysUserVO systemUser = sysUserService.login("甲");
//        Assert.assertNotNull(systemUser);
//        Assert.assertEquals(1L, systemUser.getId().longValue());
//    }

//    @Test
//    @Test(expected = RequestException.class)
//    public void testLoginFailed() {
//        expectionRule.expect(RequestException.class);
//        expectionRule.expectMessage("用户不存在");
//        sysUserService.login("丁");
//    }

//    @Test
//    public void testFind() {
//        String name = "乙";
//        SysUserDTO sysUserDTO = new SysUserDTO();
//        sysUserDTO.setName(name);
//
//        List<SysUserVO> sysUserList = sysUserService.findVO(sysUserDTO);
//        Assert.assertEquals(1, sysUserList.size());
//        Assert.assertNotNull(sysUserList.get(0).getRoles());
//        Assert.assertEquals(1, sysUserList.get(0).getRoles().size());
//    }
}