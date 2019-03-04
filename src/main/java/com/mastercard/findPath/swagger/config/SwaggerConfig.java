package com.mastercard.findPath.swagger.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	  @Bean
	    public Docket getAPI() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(Predicates.not(regex("/error*")))
	                .build()
	                .apiInfo(getMetaInfo());

	    }

	    private ApiInfo getMetaInfo() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Mastercard",
	                "APIs for Mastercard",
	                "1.0",
	                "",
	                "",
	                "",
	                "");

	        return apiInfo;
	    }

}
