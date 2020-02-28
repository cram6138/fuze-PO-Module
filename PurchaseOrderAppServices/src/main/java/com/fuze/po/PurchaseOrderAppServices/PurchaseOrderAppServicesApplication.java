package com.fuze.po.PurchaseOrderAppServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Bhajuram.c
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.fuze.po.PurchaseOrderAppServices.entity" })
public class PurchaseOrderAppServicesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOrderAppServicesApplication.class, args);
		System.out.println("PO Service Started");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PurchaseOrderAppServicesApplication.class);
	}

}
