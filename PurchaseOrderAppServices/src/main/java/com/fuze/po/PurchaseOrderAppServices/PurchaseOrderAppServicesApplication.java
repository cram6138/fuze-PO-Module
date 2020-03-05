package com.fuze.po.PurchaseOrderAppServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Bhajuram.c
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.fuze.po.PurchaseOrderAppServices.entity" })
@EnableSwagger2
public class PurchaseOrderAppServicesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOrderAppServicesApplication.class, args);
		System.out.println("PO Service Started");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PurchaseOrderAppServicesApplication.class);
	}
	
	/*--------- Swagger Implementation ----------------*/
	
	@Bean
	public Docket swaggerDocumentDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.fuze.po.PurchaseOrderAppServices")).build();
	}

}
