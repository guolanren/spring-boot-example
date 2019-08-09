package name.guolanren.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

/**
 * Swagger2 配置
 *
 * @author guolanren
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {


    @Value("${swagger2.enable:false}")
    private Boolean enable;

    @Bean
    public SecurityConfiguration securityConfiguration() {
        return SecurityConfigurationBuilder.builder()
                .clientId("swagger2")
                .clientSecret("swagger2")
                .scopeSeparator(" ")
                .build();
    }

    @Bean("SysUserApis")
    public Docket systemUserApis() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Swagger 2 —— 构建API文档")
                .contact(new Contact("guolanren", "https://found.guolanren.name", "lanrenguo@gmail.com"))
                .description("系统用户模块")
                .version("1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统用户")
                .select()
                .apis(RequestHandlerSelectors.basePackage("name.guolanren.controller"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
                .paths(PathSelectors.regex("/sys_user.*"))
                .build()
                .apiInfo(apiInfo)
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext("/sys_user.*")))
                .enable(true);
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant("/oauth/token");

        return new OAuthBuilder()
                .name("OAuth")
                .grantTypes(Collections.singletonList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    private SecurityContext securityContext(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("OAuth", scopes())))
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[] {
                new AuthorizationScope("all", "All scope is trusted!")
        };
    }
}
