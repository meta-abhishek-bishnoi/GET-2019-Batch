package com.metacube.MailSender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.MailSender.service.MailSender;
@RestController
/**
 * 
 * @author Abhishek Bishnoi
 * @since Sept 4, 2019
 * this is application Controller
 */
public class MailController {
	private MailSender mailSender;
	
	/**
	* Constructor Injection Using @Primary
	*/
	/*
	 *  @Autowired
	 	public MailController(MailSender mailSender){
	 		this.mailSender = mailSender;
	 	}
	 *
	 */
	 // Constructor Injection using name 
	/*
	 * @Autowired
	  	public MailController(MailSender mockMailSender){
	 		this.mailSender = mockMailSender;
	 	}
	 */
		// constructor injection @Qualifire
	/*
	 * @Autowired
		public MailController(@Qualifier("smtpMailSender") MailSender mailSender){
		this.mailSender = mailSender;
	}*/
	// setter using @primary 
	/*
	 * @Autowired
		public void setMailSender(MailSender mailSender) {
			this.mailSender = mailSender;
		}
	*/
	// setter injection  using name
	/*
	 * @Autowired
		public void setMailSender(MailSender smtpMailSender) {
			this.mailSender = smtpMailSender;
		}
	*/
	// setter injection using @Qualifire
	@Autowired
	public void setMailSender(@Qualifier("smtpMailSender")MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/send")
	public String sendMail(){
		return mailSender.sendMail();
	}
}
