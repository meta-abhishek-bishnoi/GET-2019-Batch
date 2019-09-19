package com.metacube.security.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/**
 * 
 * @author Abhishek Bishnoi
 * @since Sept 6, 2019
 * This is Model Of Student Entity
 */
public class Student {
	private int id;
	@NotBlank(message = "{emptyFirstName}")
	private String firstName;
	@NotBlank(message = "{emptyLastName}")
	private String lastName;
	@NotBlank(message = "{emptyFatherName}")
	private String fatherName;
	@NotBlank(message = "{emptyEmail}")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{invalidEmail}")
	private String email;
	@NotBlank(message = "{emptyStudentClass}")
	private String studentClass;
	@Min(message = "{minAge}", value = 4)
	@Max(message = "{maxAge}", value = 99)
	private int age;

	public Student(int id, String firstName, String lastName,
			String fatherName, String email, String studentClass, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", email=" + email
				+ ", studentClass=" + studentClass + ", age=" + age + "]";
	}

}
