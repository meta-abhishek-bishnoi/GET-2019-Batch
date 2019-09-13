package com.metacube.parking.model.dto;

public class Friends {
	private String imageUrl;
	private String fullName;
	private String contactNo;
	private String emailId;
	public Friends(String imageUrl, String fullName, String contactNo,
			String emailId) {
		super();
		this.imageUrl = imageUrl;
		this.fullName = fullName;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}
	public Friends() {
		super();
	}
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
