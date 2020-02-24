package com.fuze.po.fuzesoap.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.*" })
public class FuzePoSoapAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuzePoSoapAppApplication.class, args);
		System.out.println("Welcome to FUZE SOAP APPLICATION!");
	}

}
