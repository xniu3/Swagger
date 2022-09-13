package com.swaggerspring.swaggerspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //配置Swagger的Docket的Bean实例
    //Request Handler Selectors配置要扫描借口的方式，只有被扫描的借口可以在Swagger的UI上展示。
    //Base Package:直接指定要扫描的接口位置。
    //any:扫描所有的接口
    //None：所有的接口都不扫描
    //basePackage表示
    //withCLassAnnotation:扫描类的注解，参数是一个注解的反射对象，
    //withMethodAnnotation：扫描方法的注解。
    //.enable(false)是否启用swagger的标识符，若false则不能在浏览器里访问
    @Bean
    public Docket docket(Environment environment){
        //获取项目环境：
        //environment
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("prod");
        //通过environment.acceptProfiles
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Edmonton")
                //.enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swaggerspring.swaggerspring.controllers"))//.withMethodAnnotation(GetMapping.class))//.basePackage("com.swaggerspring.swaggerspring.controllers"))
                //.paths(PathSelectors.ant("/Michael/"))
                .build();

    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Calgary");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Vancouver");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Toronto");
    }
    //配置swagger文档信息= apiInfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact("Michael Niu", "https://chinadigitaltimes.net", "xniu3");
        return new ApiInfo("Swagger Document of Mr. Michael",
                "This is the document of Mr.Michael, which is from University og Alberta",
                "114.514",
                "https:google.ca" +
                        "/search",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
