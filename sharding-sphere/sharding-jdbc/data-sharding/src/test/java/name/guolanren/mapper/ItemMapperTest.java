package name.guolanren.mapper;

import name.guolanren.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void list() {
        Set<Item> items1 = itemMapper.list(2L, 1L);
        assertEquals(1, items1.size());
        System.out.println("items1: " + items1);

        Set<Item> items2 = itemMapper.list(1L, 3L);
        assertEquals(1, items2.size());
        System.out.println("items2: " + items2);
    }
}
