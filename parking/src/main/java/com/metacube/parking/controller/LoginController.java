package com.metacube.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parking.dao.TableVehicle;
import com.metacube.parking.model.dto.PlanForm;
import com.metacube.parking.model.dto.VehicleForm;
import com.metacube.parking.model.pojo.Employee;
import com.metacube.parking.model.pojo.Vehicle;
import com.metacube.parking.service.LoadProfile;
import com.metacube.parking.service.LoadVehicle;
import com.metacube.parking.util.PlanAmount;
/**
* @author Abhishek Bishnoi
* This is Controller after login, this will check about added vehicles and select plan and dashboard redirection
**/
@Controller
public class LoginController {
	public int vehicleId=0;
	/**
	* This Controller Works After Success Authentication
	**/
	@GetMapping("/login/sucess")
	public String loginSuccess(HttpServletRequest request){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		if(!employee.isHasVehical()){ // is no vehicle is added
        	return "redirect:/login/addVehicle";
        }else if(!employee.isHasPlan()){ // if no plan is selected
        	return "redirect:/login/choosePlan";
        }else{ // otherwise
        	return "redirect:/login/dashboard";
        }
	}
	/**
	* dashbord Controller
	**/
	@GetMapping("/login/dashboard")
	public String gotoDashBoardPage(Model model,HttpServletRequest request){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		//Getting employee Object
		Vehicle vehicle = LoadVehicle.loadVehicle(employee.getEmployeeId());
		// getting Vehilce Object
		model.addAttribute(vehicle);
		model.addAttribute(employee);
		return "dashboard";
	}
	
	@GetMapping("/login/addVehicle")
	public String addVehicle(HttpServletRequest request, Model model){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		// getting Employee Object
		model.addAttribute(new VehicleForm());
		model.addAttribute(employee);
		return "addVehicle";
	}
	
	@PostMapping("/login/addVehicle")
	public String actionOnAddVehicle(@Validated VehicleForm vehicleForm, BindingResult result, final RedirectAttributes redirectAttributes, 
			HttpServletRequest request,  Model model){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		model.addAttribute(employee);
		if(result.hasErrors()){
			return "addVehicle";
		}else{
			Vehicle vehicle = new Vehicle();
			vehicle.registerVehicle(++vehicleId, vehicleForm);
			TableVehicle.getInstance().addVehicle(vehicle.getEmployeeId(), vehicle);
			employee.setHasVehical(true);
			return "redirect:/login/sucess";
		}
	}
	
	@GetMapping("/login/choosePlan")
	public String choosePlan(HttpServletRequest request, Model model){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		Vehicle vehicle = LoadVehicle.loadVehicle(employee.getEmployeeId());
		PlanAmount plan = new PlanAmount().getAmount(vehicle.getType());
		model.addAttribute(employee);
		model.addAttribute(vehicle);
		model.addAttribute("plan",plan);
		model.addAttribute(new PlanForm());
		return "choosePlan";
	}
	
	@PostMapping("/login/choosePlan")
	public String actionOnChoosePlan(@Validated PlanForm planForm, BindingResult result, final RedirectAttributes redirectAttributes, 
			HttpServletRequest request,  Model model){
		Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
		Vehicle vehicle = LoadVehicle.loadVehicle(employee.getEmployeeId());
		PlanAmount plan = new PlanAmount().getAmount(vehicle.getType());
		model.addAttribute(employee);
		model.addAttribute(vehicle);
		model.addAttribute("plan",plan);
		if(result.hasErrors()){
			return "choosePlan";
		}else{
			double dollor = 70;
			vehicle.setAmount(planForm.getAmount()/dollor);
			employee.setHasPlan(true);
			return "redirect:/login/sucess";
		}
	}
}
