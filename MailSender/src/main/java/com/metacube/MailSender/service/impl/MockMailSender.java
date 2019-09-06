package com.metacube.MailSender.service.impl;

import org.springframework.stereotype.Component;
import com.metacube.MailSender.service.MailSender;

//@Component
/**
 * 
 * @author Abhishek Bishnoi
 * @since  Sept 4, 2019
 * This is Implemenation Of Mock Mail Sender
 */
public class MockMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "Send Email by Mock Email Sender";
	}

}
