package com.home.config;

import java.awt.print.Pageable;
import java.util.Date;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration { 
	private String title = "Home";
    private String description = "Home Service";
    private String version = "1.0.0";
    private String termsOfServiceUrl;
    private String contactName="LM Software";
    private String contactUrl;
    private String contactEmail = "marinus@lmsoftware.co.za";
    private String license;
    private String licenseUrl;
	
    @Bean
    public Docket api() { 
    	Contact contact = new Contact(contactName,contactUrl,contactEmail);

    	ApiInfo apiInfo = new ApiInfo(title,description,version,termsOfServiceUrl,contact,license,licenseUrl);
                
        return new Docket(DocumentationType.SWAGGER_2)  
            .pathMapping("/")
        	.apiInfo(apiInfo)
            	.forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
          .select()  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())  
          
          .build();        
    }
    
    
}

