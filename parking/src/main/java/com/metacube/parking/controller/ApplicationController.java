package com.metacube.parking.controller;\

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
/**
* @author Abhishek Bishnoi
* This is Controller for the accessable page to everyone
**/
@Controller
public class ApplicationController {
	public int registerId=0; // using register id due to inmemory db
	
	@GetMapping("/login")
	public String gotoLoginPage(Model model){
		model.addAttribute(new EmployeeLogin());
		return "login";
	}
	
	@PostMapping("/login")
	public String actionOnLogin(@Validated EmployeeLogin employeeLogin, BindingResult result, final RedirectAttributes redirectAttributes, HttpServletRequest request){
		if(result.hasErrors()){ // if validation is not applicable
			return "login";
		}else{ // if all validation is true 
			if(Authentication.authenticate(employeeLogin)){ // if authentication success
				HttpSession oldSession = request.getSession(false); // getting old session
		        if (oldSession != null) {
		        	oldSession.invalidate(); //invalidating old session
		        }
		        HttpSession newSession = request.getSession(true); // creating new session
		        newSession.setMaxInactiveInterval(5*60);
		        newSession.setAttribute("email", employeeLogin.getUsername());
		        return "redirect:/login/sucess";
			}else{ // if authentication fails
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
		// if password and confirm password mismatch
			ObjectError objectError = new ObjectError("Password","Password and Confirm Password Must Equal");
			result.addError(objectError);
			return "register";
		}
		if(result.hasErrors()){ // if form is not validating as per RegisterEmployee dto
			return "register";
		}else{ // if validation is success
			redirectAttributes.addFlashAttribute("success", "Register Sucess");
			Employee employee = new Employee();
			employee.registerEmployee(++registerId,registerEmployee); // creating employee dao
			TableEmployee.getInstance().addEmployee(employee.getEmailId(),employee); // putting employee into inmemory
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logoutUser( final RedirectAttributes redirectAttributes, HttpServletRequest request){
		HttpSession session = request.getSession(false);
        if (session != null) {
        	session.invalidate(); //inalidating session
        }
        redirectAttributes.addFlashAttribute("success", "Logout Succesfully");
        return "redirect:/login";
	}
}
