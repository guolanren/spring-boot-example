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

    @Test
    public void test() throws Exception {
        byte[] profile = Files.readAllBytes(Paths.get(PROJECT_ROOT + "src/main/resources/image.png"));

        User inUser = new User();
        inUser.setProfile(profile);

        Long rows = userMapper.insert(inUser);
        Assert.assertEquals(1L, rows.longValue());


        User outUser = userMapper.get(1L);

        Assert.assertNotNull(outUser.getProfile());
        Path profileFile = Paths.get(PROJECT_ROOT + "src/main/resources/profile.png");
        Files.write(profileFile, outUser.getProfile());
    }

}
