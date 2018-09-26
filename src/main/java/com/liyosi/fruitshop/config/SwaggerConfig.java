package com.liyosi.fruitshop.config;

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
 * Created by liyosi on Sep, 2018
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .apiInfo(metadata());
  }

  private ApiInfo metadata() {
    Contact contact = new Contact("Collins Liyosi", "https://liyosi.me", "collinskivale@gmail.com");

    return new ApiInfoBuilder()
        .contact(contact)
        .title("Fruit Shop API")
        .description("Simple API built using Spring Framework")
        .version("1.0")
        .license("Apach Licence V2.0")
        .licenseUrl("https://apache.org")
        .build();
  }
}
