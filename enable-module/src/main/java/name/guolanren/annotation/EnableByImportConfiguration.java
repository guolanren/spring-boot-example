package name.guolanren.annotation;

import name.guolanren.config.SomeConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author guolanren
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SomeConfiguration.class)
public @interface EnableByImportConfiguration {
}
