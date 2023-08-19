package com.project.yoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class YooApplication {

	public static void main(String[] args) {
		SpringApplication.run(YooApplication.class, args);
	}
	
	@Bean
	MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("properties.properties");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
	
}
