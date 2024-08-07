package com.karan.metacore.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.karan.metacore.rest"))
				.paths(PathSelectors.regex("/rest.*"))
				.build()
				.apiInfo(apiInfo())
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"WAREHOUSE APPLICATION", 
				"MetaCorp Logistcs Pvt Co.", 
				"3.2GA", 
				"http://google.com", 
				new Contact("Mr. Karan", 
						"http://google.com", 
						"karanbundele37@gmail.com"), 
				"WH LICENCE", 
				"http://google.com", 
				List.of());
	}
}
