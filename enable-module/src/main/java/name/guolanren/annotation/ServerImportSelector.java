package name.guolanren.annotation;

import name.guolanren.service.FtpServer;
import name.guolanren.service.HttpServer;
import name.guolanren.service.Server;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author guolanren
 */
public class ServerImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 读取 EnableServer 中所有的属性方法，本例中仅有 type() 属性方法
        // 其中 key 为属性方法的名称，value 为属性方法的返回对象
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableByImportImportSelector.class.getName());
        // 获取名为 "type" 的属性方法，并且强制转化为成 Server.Type类型
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        // 导入的类名称数组
        switch (type) {
            case HTTP:
                return new String[]{HttpServer.class.getName()};
            case FTP:
                return new String[]{FtpServer.class.getName()};
            default:
                return new String[0];
        }
    }

}
