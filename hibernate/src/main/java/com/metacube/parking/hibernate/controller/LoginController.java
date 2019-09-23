package com.metacube.parking.hibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parking.hibernate.model.dto.PlanForm;
import com.metacube.parking.hibernate.model.dto.VehicleForm;
import com.metacube.parking.hibernate.model.pojo.Employee;
import com.metacube.parking.hibernate.model.pojo.Vehicle;
import com.metacube.parking.hibernate.service.CommonService;
import com.metacube.parking.hibernate.util.DTOMapperUtil;
import com.metacube.parking.hibernate.util.PlanAmount;

/**
 * @author Abhishek Bishnoi
 * This is Controller Class after successful login
 */
@Controller
public class LoginController {
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/login/sucess")
	public String loginSuccess(HttpServletRequest request){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee = commonService.getEmployeeByMail(email) ;
		if(!employee.isHasVehicle()){
        	return "redirect:/login/addVehicle";
        }else if(!employee.isHasPlan()){
        	return "redirect:/login/choosePlan";
        }
		else{
        	return "redirect:/login/dashboard";
        }
	}
	
	@GetMapping("/login/dashboard")
	public String gotoDashBoardPage(Model model,HttpServletRequest request){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		Vehicle vehicle = commonService.loadVehicle(employee.getEmployeeId());
		model.addAttribute(vehicle);
		model.addAttribute(employee);
		return "dashboard";
	}
	
	@GetMapping("/login/addVehicle")
	public String addVehicle(HttpServletRequest request, Model model){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		model.addAttribute(new VehicleForm());
		model.addAttribute(employee);
		return "addVehicle";
	}
	
	@PostMapping("/login/addVehicle")
	public String actionOnAddVehicle(@Validated VehicleForm vehicleForm, BindingResult result, final RedirectAttributes redirectAttributes, 
			HttpServletRequest request,  Model model){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		model.addAttribute(employee);
		if(result.hasErrors()){
			return "addVehicle";
		}else{
			Vehicle vehicle = DTOMapperUtil.map(vehicleForm, Vehicle.class);
			commonService.addVehicle(vehicle);
			employee.setHasVehicle(true);
			commonService.setVehicleFalg(employee);
			return "redirect:/login/sucess";
		}
	}
	
	@GetMapping("/login/choosePlan")
	public String choosePlan(HttpServletRequest request, Model model){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		Vehicle vehicle = commonService.loadVehicle(employee.getEmployeeId());
		PlanAmount plan = new PlanAmount().getAmount(vehicle.getVehicleType());
		model.addAttribute(employee);
		model.addAttribute(vehicle);
		model.addAttribute("plan",plan);
		model.addAttribute(new PlanForm());
		return "choosePlan";
	}
	
	@PostMapping("/login/choosePlan")
	public String actionOnChoosePlan(@Validated PlanForm planForm, BindingResult result, final RedirectAttributes redirectAttributes, 
			HttpServletRequest request,  Model model){
		String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		Vehicle vehicle = commonService.loadVehicle(employee.getEmployeeId());
		PlanAmount plan = new PlanAmount().getAmount(vehicle.getVehicleType());
		model.addAttribute(employee);
		model.addAttribute(vehicle);
		model.addAttribute("plan",plan);
		if(result.hasErrors()){
			return "choosePlan";
		}else{
			double dollor = 70;
			vehicle.setAmount(planForm.getAmount()/dollor);
			commonService.savePlan(vehicle);
			employee.setHasPlan(true);
			commonService.setPlanFalg(employee);
			return "redirect:/login/sucess";
		}
	}
}
