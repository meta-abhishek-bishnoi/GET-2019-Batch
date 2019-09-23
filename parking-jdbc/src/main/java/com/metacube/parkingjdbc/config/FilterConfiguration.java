package com.metacube.parkingjdbc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.parkingjdbc.filter.SessionFilter;
/**
 * 
 * @author Abhishek Bishnoi
 * This is Configuration file for filter
 */
@Configuration
public class FilterConfiguration {
	@Bean
	public FilterRegistrationBean<SessionFilter> loggingFilter(){
	    FilterRegistrationBean<SessionFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new SessionFilter());
	    // applying filter on /login/*
	    registrationBean.addUrlPatterns("/login/*");  
	    return registrationBean;    
	}
}
