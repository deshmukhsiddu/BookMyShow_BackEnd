package com.bookmymovie.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sidramesh.
 *
 */
@SpringBootApplication
@EnableSwagger2
public class BookmymovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmymovieApplication.class, args);
	}

	/*
	 * Global implementation for cross origin.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
}
