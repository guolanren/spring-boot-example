package name.guolanren.service.impl;

import name.guolanren.model.Role;
import name.guolanren.service.RoleService;
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
public class RoleServiceImplTest {

    @Autowired
    protected RoleService roleService;

    @Test
    @Transactional
    @Rollback
    public void testCreate() {
        // 创建前
        Assert.assertFalse(roleService.exists(3L));

        // 创建
        Role role = new Role();
        role.setName("游客");
        roleService.create(role);

        // 创建后
        Assert.assertTrue(roleService.exists(3L));
    }

    @Test
    @Transactional
    @Rollback
    public void testRemove() {
        // 删除前
        Role beforeRemove = roleService.getById(1L);
        Assert.assertNotNull(beforeRemove);

        // 删除
        roleService.remove(1L);

        // 删除后
        Role afterRemove = roleService.getById(1L);
        Assert.assertNull(afterRemove);
    }

    @Test
    @Transactional
    @Rollback
    public void testModify() {
        // 修改前
        Role beforeModify = roleService.getById(1L);
        Assert.assertEquals("管理员", beforeModify.getName());

        // 修改
        Role role = new Role();
        role.setRoleId(1L);
        role.setName("游客");
        roleService.modify(role);

        // 修改后
        Role afterModify = roleService.getById(1L);
        Assert.assertEquals("游客", afterModify.getName());
    }

    @Test
    public void testGetById() {
        Role role = roleService.getById(1L);
        Assert.assertEquals("管理员", role.getName());

        Assert.assertNull(roleService.getById(3L));
    }

    @Test
    public void testExists() {
        Assert.assertTrue(roleService.exists(1L));
        Assert.assertFalse(roleService.exists(3L));
    }

    @Test
    public void testGetBySystemUserId() {
        Assert.assertEquals(2, roleService.getBySystemUserId(1L).size());
        Assert.assertEquals(1, roleService.getBySystemUserId(2L).size());
        Assert.assertEquals(0, roleService.getBySystemUserId(4L).size());
    }
}