package com.booking.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AereaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AereaApplication.class, args);
	}

}
