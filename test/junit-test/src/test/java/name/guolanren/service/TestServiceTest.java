package name.guolanren.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guolanren
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Autowired
    private TestService service;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetLong() {
        Assert.assertEquals(1L, service.getLong().longValue());
    }

    @Test
    public void testGetString() {
        Assert.assertEquals("string", service.getString());
    }

    @Test
    public void testGetBoolean() {
        Assert.assertTrue(service.getBoolean());
    }

    @Test(expected = RuntimeException.class)
    public void testThrowException() {
        service.throwException();
    }

    @Test
    public void testThrowExceptionRule() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("我没错");
        service.throwException();
    }
}
