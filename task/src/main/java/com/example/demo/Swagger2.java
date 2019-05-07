 /*
  * Copyright 2018 tuhu.cn All right reserved. This software is the
  * confidential and proprietary information of tuhu.cn ("Confidential
  * Information"). You shall not disclose such Confidential Information and shall
  * use it only in accordance with the terms of the license agreement you entered
  * into with Tuhu.cn
  */
 package com.example.demo;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 import springfox.documentation.builders.ApiInfoBuilder;
 import springfox.documentation.builders.PathSelectors;
 import springfox.documentation.builders.RequestHandlerSelectors;
 import springfox.documentation.service.ApiInfo;
 import springfox.documentation.spi.DocumentationType;
 import springfox.documentation.spring.web.plugins.Docket;
 import springfox.documentation.swagger2.annotations.EnableSwagger2;

 /**
  * @auther chendesheng
  * @date 2018/8/7
  */
 @Configuration
 @EnableSwagger2
 public class Swagger2{ 
     
     @Bean
     public Docket createRestApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                 .paths(PathSelectors.any())
                 .build();
     }
    
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("Spring Boot中使用Swagger2构建RESTful APIs")
                 .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                 .termsOfServiceUrl("http://blog.didispace.com/")
                 .contact("程序猿DD")
                 .version("1.0")
                 .build();
     }
 }
