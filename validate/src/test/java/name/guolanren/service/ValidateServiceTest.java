package name.guolanren.service;

import name.guolanren.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidateServiceTest {

    @Autowired
    private ValidateService validateService;

    @Test
    public void testPrint() {
        User user = new User(1L, "guolanren", (short) 26, "男");
        validateService.print(user);
    }

    @Test
    public void testEcho() {
        validateService.echo("guolanren");
    }
}
