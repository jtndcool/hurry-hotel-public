package com.book.hurryhotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HurryHotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HurryHotelsApplication.class, args);
	}

}
