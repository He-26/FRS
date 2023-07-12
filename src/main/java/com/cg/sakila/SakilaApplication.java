package com.cg.sakila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories("com.cg.sakila.repository")
@SpringBootApplication
@EnableSwagger2
@Configuration
public class SakilaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaApplication.class, args);
	}
	

    @Bean
     public Docket api() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .useDefaultResponseMessages(false)
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.cg.sakila"))
                 .paths(PathSelectors.any())
                 .build();
     }
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("WLCOME TO SAKILA")
                 .description("CHECK ME")
                 .version("1.0.0")
                 .build();
     }

}
