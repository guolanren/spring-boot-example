package name.guolanren.mapper;

import name.guolanren.model.User;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void list() {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.setDatabaseShardingValue(1L);
            Set<User> orders = userMapper.list();
            orders.forEach(System.out::println);

            hintManager.setDatabaseShardingValue(2L);
            Set<User> items = userMapper.list();
            items.forEach(System.out::println);
        }
    }
}
