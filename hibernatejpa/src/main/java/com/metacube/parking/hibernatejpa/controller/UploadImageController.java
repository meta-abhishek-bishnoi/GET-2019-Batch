package com.metacube.parking.hibernatejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;





import com.metacube.parking.hibernatejpa.model.pojo.Employee;
import com.metacube.parking.hibernatejpa.service.CommonService;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadImageController {
	@Autowired
	private CommonService commonService;
    public static final String uploadingDir = System.getProperty("user.dir") + "/src/main/resources/static/images/";

    @GetMapping("/login/uploadImage")
    public String uploading(Model model, HttpServletRequest request) {
    	String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		model.addAttribute(employee);
        File file = new File(uploadingDir);
        model.addAttribute("files", file.listFiles());
        return "uploadImage";
    }

    @PostMapping("/login/uploadImage")
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,
    		HttpServletRequest request, Model model) throws IOException {
    	String email = request.getSession().getAttribute("email").toString();
		Employee employee =commonService.getEmployeeByMail(email) ;
		model.addAttribute(employee);
    	int index = email.indexOf('@');
    	email = email.substring(0,index);
        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
            employee.setProfileImageUrl("/images/" + uploadedFile.getOriginalFilename());
            commonService.updateProfileImage(employee);
        }
        return "redirect:/login/sucess";
    }
}