package com.metacube.MailSender.service;
/**
 * 
 * @author Abhishek Bishnoi
 * @since  Sept 4, 2019
 * This is interface of Mailsender
 */
public interface MailSender {
	/**
	 * This function writes the message from where we send a mail
	 * @return message String
	 */
	String sendMail();
}
