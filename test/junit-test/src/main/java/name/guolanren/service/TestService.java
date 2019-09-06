package name.guolanren.service;

import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class TestService {

    public Long getLong() {
        return 1L;
    }

    public String getString() {
        return "string";
    }

    public Boolean getBoolean() {
        return true;
    }

    public Object throwException() {
        throw new RuntimeException("我错了");
    }
}
