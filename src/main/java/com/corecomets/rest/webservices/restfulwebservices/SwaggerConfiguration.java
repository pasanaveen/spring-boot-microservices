package com.corecomets.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
//enable swagger
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	//Create a Docket bean and return the document type of swagger 2
	// By doing this swagger will provide a documentation of all the paths and apis which are exposed, so that the consumer knows what to call
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	
}

