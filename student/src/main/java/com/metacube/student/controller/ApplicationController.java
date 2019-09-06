package com.metacube.student.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.student.dao.StudentDB;
import com.metacube.student.model.Student;
/**
 * 
 * @author Abhishek Bishnoi
 * @since Sept 6,2019
 * This is controller class for application
 *
 */
@Controller
public class ApplicationController {
	
	@Value("${home.message}")
	private String message;
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("message",message);
		return "index";
	}
	
	@GetMapping("/addStudent")
	public String addStudentGetRequest(Model model){
		model.addAttribute(new Student());
		return "addstudent";
	}
	
	@PostMapping("/addStudent")
	public String addStudentPostRequest(@Validated Student student, BindingResult result, final RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "addstudent";
		}else{
			System.out.println("Student Added Successfully :"+student.toString());
			redirectAttributes.addFlashAttribute("success", "User updated successfully");
			return "redirect:/";
		}
	}
	
	@GetMapping("/getStudents")
	public String listStudents(Model model){
		model.addAttribute("listStudents",StudentDB.getStudents());
		return "liststudents";
	}

}
