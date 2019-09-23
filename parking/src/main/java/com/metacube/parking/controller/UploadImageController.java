package com.metacube.parking.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.parking.model.pojo.Employee;
import com.metacube.parking.service.LoadProfile;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
* @author Abhishek Bishnoi
* This is Controller for Uploading Image
**/
@Controller
public class UploadImageController {
    // location where image will uploaded
    public static final String uploadingDir = System.getProperty("user.dir") + "/src/main/resources/static/images/";

    @GetMapping("/login/uploadImage")
    public String uploading(Model model, HttpServletRequest request) {
    	Employee employee = LoadProfile.LoadProfile(request.getSession().getAttribute("email").toString());
    	// getting Employee from it's mail
        model.addAttribute(employee);
        File file = new File(uploadingDir);
        model.addAttribute("files", file.listFiles());
        return "uploadImage";
    }

    @PostMapping("/login/uploadImage")
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,
    		HttpServletRequest request, Model model) throws IOException {
    	String email = request.getSession().getAttribute("email").toString();
    	Employee employee = LoadProfile.LoadProfile(email);
    	model.addAttribute(employee);
        /**
        * This is uploading image from request
        * only single file is uploading
        */
        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
            // transfering file to dir
            uploadedFile.transferTo(file);
            // setting image path for employee object
            employee.setProfileImageUrl("/images/" + uploadedFile.getOriginalFilename());
        }
        return "redirect:/login/sucess";
    }
}