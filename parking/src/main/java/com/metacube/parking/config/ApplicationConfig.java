package com.metacube.parking.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.metacube.parking.filter.SessionFilter;
/**
* @author Abhishek Bishnoi
* This is Configuartion Class Of Application
*/
@Configuration
public class ApplicationConfig implements WebMvcConfigurer{
	/**
	* redirect '/' request to /login 
	**/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/login");
	}
}
