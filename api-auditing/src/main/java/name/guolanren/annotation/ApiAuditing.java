package name.guolanren.annotation;

import java.lang.annotation.*;

/**
 * @author guolanren
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiAuditing {
    String menu() default "";
    String type() default "";
}

