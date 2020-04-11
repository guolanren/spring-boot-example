package name.guolanren.annotation;

import java.lang.annotation.*;

/**
 * @author guolanren
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotations {

    AopAnnotation[] value();

}
