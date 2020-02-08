package com.fuze.po;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EntityScan( basePackages = {"com.fuze.po.model"} )
public class FusePoModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FusePoModuleApplication.class, args);
	}

}
