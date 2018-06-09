package com.corecomets.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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
	
	//use http://localhost:8080/v2/api-docs to view th swagger documentation as a json format
	// use http://localhost:8080/swagger-ui.html to view the document a html page.
	
	public static final Contact DEFAULT_CONTACT = new Contact("core comets", "corecomets.com", "corecomets@noemailyet.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("corecoments Documentation", "corecoments  Documentation Description", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)					//sets the info to custom info in the documentation
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)		//sets the produces as json and xml in documentation
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES); 	//Sets the Consumes as json and xml
	}
	
}

