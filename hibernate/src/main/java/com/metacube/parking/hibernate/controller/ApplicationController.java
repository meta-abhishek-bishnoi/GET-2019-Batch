package com.metacube.parking.hibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parking.hibernate.model.dto.EmployeeLogin;
import com.metacube.parking.hibernate.model.dto.RegisterEmployee;
import com.metacube.parking.hibernate.model.pojo.Employee;
import com.metacube.parking.hibernate.service.CommonService;
import com.metacube.parking.hibernate.util.DTOMapperUtil;

/**
 * @author Abhishek Bishnoi
 * This is Controller Class with no flitering
 */
@Controller
public class ApplicationController {
	@Autowired
	private CommonService commonService;

	@GetMapping("/login")
	public String gotoLoginPage(Model model) {
		model.addAttribute(new EmployeeLogin());
		return "login";
	}

	@PostMapping("/login")
	public String actionOnLogin(@Validated EmployeeLogin employeeLogin,
			BindingResult result, final RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		if (result.hasErrors()) { // if validation is not applicable
			return "login";
		} else {  //otherwise
			if (commonService.authenticate(employeeLogin)) { // if authentication success
				HttpSession oldSession = request.getSession(false);
				if (oldSession != null) {
					oldSession.invalidate();
				}
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(5 * 60);
				newSession.setAttribute("email", employeeLogin.getUsername());
				return "redirect:/login/sucess";
			} else { // authentication failure
				ObjectError objectError = new ObjectError("fail", "Username Or Password Mismatch");
				result.addError(objectError);
				return "login";
			}
		}
	}

	@GetMapping("/register")
	public String gotoRegisterPage(Model model) {
		model.addAttribute(new RegisterEmployee());
		return "register";
	}

	@PostMapping("/register")
	public String actionOnRegister(
			@Validated RegisterEmployee registerEmployee, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (!registerEmployee.getPassword().equals(
				registerEmployee.getConfirmPassword())) {// if password and confirm mismatch
			ObjectError objectError = new ObjectError("Password",
					"Password and Confirm Password Must Equal");
			result.addError(objectError);
			return "register";
		}
		if (result.hasErrors()) {// if form is not validating as per RegisterEmployee dto
			return "register";
		} else {
			redirectAttributes.addFlashAttribute("success", "Register Sucess");
			Employee employee = DTOMapperUtil.map(registerEmployee, Employee.class);
			commonService.register(employee);
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logoutUser(final RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		redirectAttributes.addFlashAttribute("success", "Logout Succesfully");
		return "redirect:/login";
	}
}
