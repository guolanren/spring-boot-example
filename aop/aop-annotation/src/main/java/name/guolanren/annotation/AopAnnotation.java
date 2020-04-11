package name.guolanren.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author guolanren
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(AopAnnotations.class)
public @interface AopAnnotation {

    @AliasFor("condition")
    String value() default "true";

    @AliasFor("value")
    String condition() default "";
}
