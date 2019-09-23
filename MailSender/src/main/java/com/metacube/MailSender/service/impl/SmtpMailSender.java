package com.metacube.MailSender.service.impl;

import org.springframework.stereotype.Component;

import com.metacube.MailSender.service.MailSender;
//@Component
/**
 * 
 * @author Abhishek Bishnoi
 * @since  Sept 4, 2019
 * This is Implemenation Of Smtp Sender
 */
public class SmtpMailSender implements MailSender{

	@Override
	public String sendMail() {
		return "Email Send By Smtp Email Sender";
	}

}
