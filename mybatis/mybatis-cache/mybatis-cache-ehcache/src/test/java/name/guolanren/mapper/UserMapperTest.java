package name.guolanren.mapper;

import name.guolanren.model.User;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * @author guolanren
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    public static final String PROJECT_ROOT = "D:/workspaces/IdeaProjects/spring-boot-example/mybatis/mybatis-blob/";

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试一级缓存
     * 使用 @Transactional 保证一个会话
     */
    @Test
    @Transactional
    public void testL1Cache() {
        // 执行 sql
        User u1 = userMapper.get(1L);
        // 命中缓存
        User u2 = userMapper.get(1L);
        Assert.assertEquals(System.identityHashCode(u1), System.identityHashCode(u2));

        // 刷新缓存
        userMapper.delete(3L);
        // 执行 sql
        User u3 = userMapper.get(1L);
        Assert.assertNotEquals(System.identityHashCode(u1), System.identityHashCode(u3));
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testL2Cache() {
        // 执行 sql
        User u1 = userMapper.get(1L);
        // 命中缓存
        User u2 = userMapper.get(1L);
        // 刷新缓存
        userMapper.delete(3L);
        // 执行 sql
        User u3 = userMapper.get(1L);
    }
}
