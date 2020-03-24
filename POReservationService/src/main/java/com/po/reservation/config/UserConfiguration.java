package com.po.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UserConfiguration {

	@Bean
	public Jaxb2Marshaller marshlar() {
		Jaxb2Marshaller marshlar = new Jaxb2Marshaller();
		marshlar.setPackagesToScan("com.po.*");
		return marshlar;
	}

}
