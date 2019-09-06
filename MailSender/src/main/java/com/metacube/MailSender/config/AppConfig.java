package com.metacube.MailSender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.MailSender.service.MailSender;
import com.metacube.MailSender.service.impl.MockMailSender;
import com.metacube.MailSender.service.impl.SmtpMailSender;
/**
 * 
 * @author Abhishek Bishnoi
 * @since Sept 4, 2019
 * this is application config file
 */
@Configuration
public class AppConfig {
	
	@Bean
	//@Primary
	public MailSender mockMailSender(){
		return new MockMailSender();
	}
	
	@Bean
	public MailSender smtpMailSender(){
		return new SmtpMailSender();
	}
}
