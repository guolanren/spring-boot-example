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
        itemMapper.createOrder(1L, 1L);
        itemMapper.createItem(1L, "PS5");
        itemMapper.createItem(1L, "NS");

        Set<Item> items = itemMapper.list(1L, 1L);
        assertEquals(2, items.size());
        System.out.println("items: " + items);
    }
}
