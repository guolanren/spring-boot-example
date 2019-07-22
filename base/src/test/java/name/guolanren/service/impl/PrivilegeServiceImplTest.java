package name.guolanren.service.impl;

import name.guolanren.model.Privilege;
import name.guolanren.service.PrivilegeService;
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
public class PrivilegeServiceImplTest {

    @Autowired
    protected PrivilegeService privilegeService;

    @Test
    @Transactional
    @Rollback
    public void testCreate() {
        // 创建前
        Assert.assertFalse(privilegeService.exists(4L));

        // 创建
        Privilege privilege = new Privilege();
        privilege.setName("日志管理");
        privilege.setUrl("/auditingManage");
        privilegeService.create(privilege);

        // 创建后
        Assert.assertTrue(privilegeService.exists(4L));
    }

    @Test
    @Transactional
    @Rollback
    public void testRemove() {
        // 删除前
        Privilege beforeRemove = privilegeService.getById(1L);
        Assert.assertNotNull(beforeRemove);

        // 删除
        privilegeService.remove(1L);

        // 删除后
        Privilege afterRemove = privilegeService.getById(1L);
        Assert.assertNull(afterRemove);
    }

    @Test
    @Transactional
    @Rollback
    public void testModify() {
        // 修改前
        Privilege beforeModify = privilegeService.getById(1L);
        Assert.assertEquals("用户管理", beforeModify.getName());

        // 修改
        Privilege privilege = new Privilege();
        privilege.setPrivilegeId(1L);
        privilege.setName("日志管理");
        privilegeService.modify(privilege);

        // 修改后
        Privilege afterModify = privilegeService.getById(1L);
        Assert.assertEquals("日志管理", afterModify.getName());
    }

    @Test
    public void testGetById() {
        Privilege privilege = privilegeService.getById(1L);
        Assert.assertEquals("用户管理", privilege.getName());

        Assert.assertNull(privilegeService.getById(4L));
    }

    @Test
    public void testExists() {
        Assert.assertTrue(privilegeService.exists(1L));
        Assert.assertFalse(privilegeService.exists(4L));
    }

    @Test
    public void testGetByRoleId() {
        Assert.assertEquals(3, privilegeService.getByRoleId(1L).size());
        Assert.assertEquals(1, privilegeService.getByRoleId(2L).size());
        Assert.assertEquals(0, privilegeService.getByRoleId(0L).size());
    }

}