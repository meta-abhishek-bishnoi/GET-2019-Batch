package com.metacube.parkingjdbc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parkingjdbc.model.dto.EditEmployee;
import com.metacube.parkingjdbc.model.dto.Friend;
import com.metacube.parkingjdbc.model.pojo.Employee;
import com.metacube.parkingjdbc.service.CommonService;

@Controller
public class UserOperationController {
	@Autowired
	private CommonService commonService;
	@GetMapping("/login/editProfile")
	public String editProfile(HttpServletRequest request, Model model){
		model.addAttribute(new EditEmployee());
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		model.addAttribute(employee);
		return "editProfile";
	}
	
	@PostMapping("/login/editProfile")
	public String actionOnEditProfile(@Validated EditEmployee editEmployee, BindingResult result, final RedirectAttributes redirectAttributes, 
			HttpServletRequest request,  Model model){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		model.addAttribute(employee);
		if(result.hasErrors()){
			return "editProfile";
		}else{
			employee.setFullName(editEmployee.getFullName());
			employee.setContactNo(editEmployee.getContactNo());
			commonService.updateUserProfile(employee);
			return "redirect:/login/sucess";
		}
	}
	
	@GetMapping("/login/friends")
	public String friends(HttpServletRequest request, Model model){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		List<Friend> list = commonService.getFriends(employee);
		model.addAttribute(employee);
		model.addAttribute("friendList",list);
		return "friends";
	}
}
