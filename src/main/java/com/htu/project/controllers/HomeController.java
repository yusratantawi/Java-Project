package com.htu.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/PatientDashBoard")
	public ModelAndView patientDashboard() {
		return new ModelAndView("patientDashBoard");
	}

	@RequestMapping("/SecretaryDashboard")
	public ModelAndView secretaryDashboard() {
		return new ModelAndView("SecretaryDashboard");
	}
}
