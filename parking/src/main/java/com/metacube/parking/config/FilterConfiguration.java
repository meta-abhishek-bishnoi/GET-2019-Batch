package com.metacube.parking.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.parking.filter.SessionFilter;
/**
* @author Abhishek Bishnoi
* This is Configuration Class For Filter
**/
@Configuration
public class FilterConfiguration {
	/**
	* This Function Defines Configuration for Filtering
	**/
	@Bean
	public FilterRegistrationBean<SessionFilter> loggingFilter(){
	    FilterRegistrationBean<SessionFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new SessionFilter());
	    // filtering is applicable on /login/*
	    registrationBean.addUrlPatterns("/login/*");  
	    return registrationBean;    
	}
}
