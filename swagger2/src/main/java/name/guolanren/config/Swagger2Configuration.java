package name.guolanren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置
 *
 * @author guolanren
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger 2 —— 构建API文档")
                .description("描述内容")
                .contact(new Contact("guolanren", "https://found.guolanren.name", "lanrenguo@gmail.com"))
                .version("1.0")
                .build();
    }

    @Bean("SystemUserApis")
    public Docket systemUserApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统用户")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leayun.bdc.controller"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
                .paths(PathSelectors.regex("/systemUser.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(true);
    }

}
