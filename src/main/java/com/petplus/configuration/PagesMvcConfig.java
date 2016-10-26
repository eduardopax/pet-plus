package com.petplus.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class PagesMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// login
		registry.addViewController("/login").setViewName("login");
		
		registry.addViewController("/list").setViewName("list");
		
		registry.addViewController("/operationNOk").setViewName("operationNOk");
		
		registry.addViewController("/operationOk").setViewName("operationOk");
		
		registry.addViewController("/surveyQuestions").setViewName("surveyQuestions");

		registry.addViewController("/").setViewName("index");
	}

}
