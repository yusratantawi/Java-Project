package com.htu.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.htu.project.models.Patients;
import com.htu.project.services.PatientService;



@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping(value = "/patients")
	public @ResponseBody List<Patients> getAllPatients() {
		return patientService.getAllPatients();
	}
	@GetMapping(value = "/patients/{id}")
	public @ResponseBody Patients getPatientById(@PathVariable Integer id ) {
		return patientService.getPatientById(id);
	}

	
	@PostMapping(value = "/patients")
	  public @ResponseBody Patients createPatient( @RequestBody Patients patient) {
		return patientService.createPatient(patient);
		
	}
	@PutMapping (value="/patients/{id}")
	public  @ResponseBody Patients updatePatient (@PathVariable Integer id,@RequestBody Patients patient) {
		return patientService.updatePatient(id, patient);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/patients/{id}")
	public @ResponseBody void deletepatient(@PathVariable Integer id) {
		patientService.deletePatient(id);
	}
	
	
	
}