package com.bet.springboot.crudrestfullwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringbootCrudRestfullWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudRestfullWebservicesApplication.class, args);
	}
	
	@Bean
	 public Docket benefitsApi() {
	 return new Docket(DocumentationType.SWAGGER_2).groupName("MatchOdds")
	 .apiInfo(apiInfo())
	 .select()
	 .apis(RequestHandlerSelectors.any())
	 .paths(PathSelectors.any())
	 .build()
	 .pathMapping("/");

	}

	private ApiInfo apiInfo() {
	 return new ApiInfoBuilder().title("Benefits REST Service")
	 .description(" A simple REST web api service for managing a sport match and represent odds")
	 .version("1.0")
	 .build();
	 }

}
