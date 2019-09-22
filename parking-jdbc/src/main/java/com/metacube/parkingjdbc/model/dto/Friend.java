package com.metacube.parkingjdbc.model.dto;
/**
 * 
 * @author Abhishek Bishnoi
 * DTO for Friend
 */
public class Friend {
	private String imageUrl;
	private String fullName;
	private String contactNo;
	private String emailId;

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
