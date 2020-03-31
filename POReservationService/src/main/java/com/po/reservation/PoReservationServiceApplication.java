package com.po.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PoReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoReservationServiceApplication.class, args);
	}

}
