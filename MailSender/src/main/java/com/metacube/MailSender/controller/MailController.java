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
	
	/*
	 *  @Autowired
	 	public MailController(MailSender mailSender){
	 		this.mailSender = mailSender;
	 	}
	 *
	 */
	/*
	 * @Autowired
	  	public MailController(MailSender mockMailSender){
	 		this.mailSender = mockMailSender;
	 	}
	 */
	/*
	 * @Autowired
		public MailController(@Qualifier("smtpMailSender") MailSender mailSender){
		this.mailSender = mailSender;
	}*/
	
	/*
	 * @Autowired
		public void setMailSender(MailSender mailSender) {
			this.mailSender = mailSender;
		}
	*/
	
	/*
	 * @Autowired
		public void setMailSender(MailSender smtpMailSender) {
			this.mailSender = smtpMailSender;
		}
	*/
	
	@Autowired
	public void setMailSender(@Qualifier("smtpMailSender")MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/send")
	public String sendMail(){
		return mailSender.sendMail();
	}
}
