package name.guolanren.annotation;

import name.guolanren.service.Server;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author guolanren
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportSelector.class)
public @interface EnableByImportImportSelector {

    Server.Type type();

}
