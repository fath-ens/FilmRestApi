package com.filmrestapi.filmapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.filmrestapi.filmapi")
public class FilmapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmapiApplication.class, args);
	}

}
