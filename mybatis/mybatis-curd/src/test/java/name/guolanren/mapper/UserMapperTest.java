package name.guolanren.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import name.guolanren.model.User;
import name.guolanren.model.UserVO;
import org.junit.Test;
import org.junit.Assert;
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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    @Rollback
    public void testInsert() {
        User user = new User();
        user.setName("guolanren4");
        user.setAge(26);

        Long rows = userMapper.insert(user);
        Assert.assertEquals(1L, rows.longValue());
        Assert.assertEquals(4L, user.getId().longValue());
    }

    @Test
    @Transactional
    @Rollback
    public void testDelete() {
        Long rows = userMapper.delete(1L);
        Assert.assertEquals(1L, rows.longValue());
        Assert.assertNull(userMapper.get(1L));
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setAge(30);

        Long rows = userMapper.update(user);
        Assert.assertEquals(1L, rows.longValue());
        Assert.assertEquals(30, userMapper.get(1L).getAge().intValue());
    }

    @Test
    @Transactional
    public void testGet() {
        User user = userMapper.get(1L);

        Assert.assertNotNull(user);
        Assert.assertEquals("guolanren1", user.getName());
        Assert.assertEquals(23, user.getAge().intValue());
    }

    @Test
    public void testGetVO() {
        UserVO userVO = userMapper.getVO(3L);

        Assert.assertNotNull(userVO);
        Assert.assertEquals("guolanren3", userVO.getName());

        Assert.assertNotNull(userVO.getGoal());
        Assert.assertEquals(2, userVO.getPcs().size());
        Assert.assertEquals(3, userVO.getLanguages().size());
    }
}
