package com.metacube.security.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.security.model.Student;


/**
 * 
 * @author Abhishek Bishnoi 
 * @since Sept 6, 2019
 * This class works as db for application where hard coded data is stored
 */
public class StudentDB {
	public static List<Student> getStudents(){
		List<Student> students = new  ArrayList<Student>();
		students.add(new Student(1,"Abhishek","Bishnoi","Radheshyam","abhishek.bishnoi.2015@campus.com","BTech-CSE-2015",22));
		students.add(new Student(2,"Vijay","Malya","Mr Malya","vijay.malya.2014@campus.com","BBA_MBA_DUAL-Finacial-Fraud-Management-2014",62));
		students.add(new Student(3,"Nirav","modi","mr Modi","nirav.modi.2014@campus.com","BBA_MBA_DUAL-Finacial-Fraud-Management-2014",55));
		students.add(new Student(4,"Shreyash","Khandelwal","Mr Khandelwal","shreyash.khandelwal.2015@campus.com","BTech-CSE-2015",22));
		students.add(new Student(5,"Yatika","Bansal","Mr Bansal","yatika.bansal.2015@campus.com","BTech-CSE-2015",22));
		students.add(new Student(6,"Manoj","Sharma","Mr Sharma","manoj.sharma.2015@campus.com","BTech-CSE-2015",22));
		return students;
	}
}
