package com.metacube.parking.hibernate.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.parking.hibernate.filter.SessionFilter;


@Configuration
public class FilterConfiguration {
	@Bean
	public FilterRegistrationBean<SessionFilter> loggingFilter(){
	    FilterRegistrationBean<SessionFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new SessionFilter());
	    registrationBean.addUrlPatterns("/login/*");  
	    return registrationBean;    
	}
}
