package com.htu.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.htu.project.models.Patients;
import com.htu.project.services.PatientService;

@Controller
public class HomeController {
	@Autowired
	PatientService patientService;
	@GetMapping("home") 
	public String Home(Model model) {
		List<Patients> s = patientService.getAllPatients();
		model.addAttribute("patients", s);
		return "home";
	}
	
	@GetMapping("login") 
	public String login() {
	
		return "login";
	}

}
