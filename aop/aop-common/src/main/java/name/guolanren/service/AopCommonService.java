package name.guolanren.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author guolanren
 */
@Service
public class AopCommonService {

    public String service(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("名字不能为空");
        }
        System.out.printf("service for %s ...%n", name);
        return name.toUpperCase();
    }

}
