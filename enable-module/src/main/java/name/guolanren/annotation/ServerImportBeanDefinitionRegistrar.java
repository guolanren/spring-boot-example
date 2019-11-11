package name.guolanren.annotation;

import name.guolanren.service.FtpServer;
import name.guolanren.service.HttpServer;
import name.guolanren.service.Server;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author guolanren
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 读取 EnableServer 中所有的属性方法，本例中仅有 type() 属性方法
        // 其中 key 为属性方法的名称，value 为属性方法的返回对象
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableByImportImportBeanDefinitionRegistrar.class.getName());
        // 获取名为 "type" 的属性方法，并且强制转化为成 Server.Type类型
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        // 导入的类名称数组
        String[] importClassNames;
        switch (type) {
            case HTTP:
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
            default:
                importClassNames = new String[0];
        }

        // 创建 Bean 定义
        Stream.of(importClassNames)
                // 转化为 BeanDefinitionBuilder 对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为 BeanDefinition
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition ->
                        // 注册 BeanDefinition 到 BeanDefinitionRegistry
                        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, beanDefinitionRegistry));
    }

}
