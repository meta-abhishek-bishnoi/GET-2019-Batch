package com.metacube.parking.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parking.dao.TableVehicle;
import com.metacube.parking.model.dto.EditEmployee;
import com.metacube.parking.model.dto.Friends;
import com.metacube.parking.model.dto.VehicleForm;
import com.metacube.parking.model.pojo.Employee;
import com.metacube.parking.model.pojo.Vehicle;
import com.metacube.parking.service.LoadProfile;

/**
* @author Abhishek Bishnoi
* This is Controller for Dashbord Functionalities
**/
@Controller
public class DashboardController {

	@GetMapping("/login/editProfile")
	public String editProfile(HttpServletRequest request, Model model){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		// loading employee from db
		model.addAttribute(new EditEmployee());
		model.addAttribute(employee);
		return "editProfile";
	}
	
	@PostMapping("/login/editProfile")
	public String actionOnEditProfile(@Validated EditEmployee editEmployee, BindingResult result, final RedirectAttributes redirectAttributes, 
			HttpServletRequest request,  Model model){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		model.addAttribute(employee);
		if(result.hasErrors()){ // if EditEmployee dto has validation error
			return "editProfile";
		}else{ // otherwise
			employee.editProfile(editEmployee);
			return "redirect:/login/sucess";
		}
	}
	
	@GetMapping("/login/friends")
	public String friends(HttpServletRequest request, Model model){
		String email = request.getSession().getAttribute("email").toString();
		// getting email from session
		Employee employee = LoadProfile.LoadProfile(email);
		String oragnization = employee.getEmployeeOragnization();
		// loading freind list from database
		List<Friends> list = LoadProfile.loadFriends(email, oragnization);
		model.addAttribute(employee);
		model.addAttribute("friendList",list);
		return "friends";
	}
}
