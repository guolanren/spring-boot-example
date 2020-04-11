package name.guolanren.service;

import name.guolanren.annotation.AopAnnotation;
import name.guolanren.annotation.AopAnnotations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author guolanren
 */
@Service
public class AopAnnotationService {

    @AopAnnotations({
            @AopAnnotation(condition = "true'")
    })
    public String requiredAopService(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("名字不能为空");
        }
        System.out.printf("service for %s ...%n", name);
        return name.toUpperCase();
    }

    @AopAnnotations({
            @AopAnnotation(condition = "false")
    })
    public String noNeedAopService(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("名字不能为空");
        }
        System.out.printf("service for %s ...%n", name);
        return name.toUpperCase();
    }

    @AopAnnotations({
            @AopAnnotation(condition = "#name == 'guolanren'")
    })
    public String service(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("名字不能为空");
        }
        System.out.printf("service for %s ...%n", name);
        return name.toUpperCase();
    }
}
