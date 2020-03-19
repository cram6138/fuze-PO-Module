package com.fuze.po.PurchaseOrderAppUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = { "com.fuze.po.PurchaseOrderAppUI.auth" })
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class PurchaseOrderAppUiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOrderAppUiApplication.class, args);
		System.out.println("Build done Successfully");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PurchaseOrderAppUiApplication.class);
	}

}
