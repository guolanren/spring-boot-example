package name.guolanren.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AopCommonServiceTest {

    @Autowired
    private AopCommonService aopCommonService;

    @Test
    public void testService() {
        aopCommonService.service("guolanren");
    }

    @Test(expected = RuntimeException.class)
    public void testServiceException() {
        aopCommonService.service("");
    }
}
