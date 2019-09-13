package com.metacube.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;















import com.metacube.parking.dao.TableEmployee;
import com.metacube.parking.dao.TableVehicle;
import com.metacube.parking.model.dto.EmployeeLogin;
import com.metacube.parking.model.dto.RegisterEmployee;
import com.metacube.parking.model.dto.VehicleForm;
import com.metacube.parking.model.pojo.Employee;
import com.metacube.parking.model.pojo.Vehicle;
import com.metacube.parking.service.Authentication;
import com.metacube.parking.service.LoadProfile;
import com.metacube.parking.service.LoadVehicle;
@Controller
public class ApplicationController {
	public int registerId=0;
	@GetMapping("/login")
	public String gotoLoginPage(Model model){
		model.addAttribute(new EmployeeLogin());
		return "login";
	}
	
	@PostMapping("/login")
	public String actionOnLogin(@Validated EmployeeLogin employeeLogin, BindingResult result, final RedirectAttributes redirectAttributes, HttpServletRequest request){
		if(result.hasErrors()){
			return "login";
		}else{
			if(Authentication.authenticate(employeeLogin)){
				HttpSession oldSession = request.getSession(false);
		        if (oldSession != null) {
		        	oldSession.invalidate();
		        }
		        HttpSession newSession = request.getSession(true);
		        newSession.setMaxInactiveInterval(5*60);
		        newSession.setAttribute("email", employeeLogin.getUsername());
		        return "redirect:/login/sucess";
			}else{
				ObjectError objectError = new ObjectError("fail","Username Or Password Mismatch");
				result.addError(objectError);
				return "login";
			}
		}
	}
	
	@GetMapping("/register")
	public String gotoRegisterPage(Model model){
		model.addAttribute(new RegisterEmployee());
		return "register";
	}
	
	@PostMapping("/register")
	public String actionOnRegister(@Validated RegisterEmployee registerEmployee, BindingResult result, final RedirectAttributes redirectAttributes){
		if(!registerEmployee.getPassword().equals(registerEmployee.getConfirmPassword())){
			ObjectError objectError = new ObjectError("Password","Password and Confirm Password Must Equal");
			result.addError(objectError);
			return "register";
		}
		if(result.hasErrors()){
			return "register";
		}else{
			redirectAttributes.addFlashAttribute("success", "Register Sucess");
			Employee employee = new Employee();
			employee.registerEmployee(++registerId,registerEmployee);
			TableEmployee.getInstance().addEmployee(employee.getEmailId(),employee);
			return "redirect:/login";
		}
	}
	@GetMapping("/logout")
	public String logoutUser( final RedirectAttributes redirectAttributes, HttpServletRequest request){
		HttpSession session = request.getSession(false);
        if (session != null) {
        	session.invalidate();
        }
        redirectAttributes.addFlashAttribute("success", "Logout Succesfully");
        return "redirect:/login";
	}
}
