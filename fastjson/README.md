# fastjson

## 概述

fastjson 概述...

## 2019

------

### 06

------

#### fastjson替换jackson (2019-06-17)

在**Spring Boot**中，默认的**json**框架是**jackson**。因为项目需要，统一采用**fastjson**。

根据官方[wiki](https://github.com/alibaba/fastjson/wiki/%E5%9C%A8-Spring-%E4%B8%AD%E9%9B%86%E6%88%90-Fastjson#%E7%BC%96%E7%A8%8B%E5%BC%8F)介绍，替换仅需配置自定义的**MessageConverters**。

```java
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        //FastJsonConfig config = new FastJsonConfig();
        //config.set ...
        //converter.setFastJsonConfig(config);
        converters.add(0, converter);
    }
}
```

------

#### 'Content-Type' cannot contain wildcard type '*' (2019-06-17)

高版本**fastjson**中的**supportedMediaTypes**为**MediaType.ALL(\*/\*)**导致序列化异常。通过配置**FastJsonHttpMessageConverter**时，设置**supportedMediaTypes**。

```java
List<MediaType> supportedMediaTypes = new ArrayList<>();
supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
fastConverter.setSupportedMediaTypes(supportedMediaTypes);
```

------

### 参考