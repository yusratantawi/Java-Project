package com.htu.project.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.project.models.Patients;
import com.htu.project.models.User;
import com.htu.project.repositories.PatientRepo;

 

@Service
public class PatientService {
		@Autowired 
		private PatientRepo patientRepo;
		@Autowired
		private UserService userService;
		
		
	public  List<Patients> getAllPatients() {
		return patientRepo.findAll();
	}

	public Patients getPatientById(Integer id ) {
		Optional<Patients> patientOptional = patientRepo.findById(id);
		if(patientOptional.isPresent()) {
			return patientOptional.get();
			
		}
		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "entity not found"
				);
	
	}	
	
	  public Patients createPatient(Patients patient) {
		User createdUser = userService.createUser(patient.getUser());
		patient.setUser(createdUser);
		return patientRepo.save(patient);
		
	}
	  public Patients updatePatient(Integer id,Patients patient) {
		  Optional<Patients> patientsOptional = patientRepo.findById(id);
			if(patientsOptional.isPresent()) {
				Patients patientObj = patientsOptional.get();
				patientObj.setPatientName(patient.getPatientName());
				patientObj.setPatientBod(patient.getPatientBod());
				patientObj.setPatientPhone(patient.getPatientPhone());
				patientRepo.save(patientObj);
				return patientObj ;
												}
			
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
	  
		public void deletePatient( Integer id) {
			Optional<Patients> patientsOptional = patientRepo.findById(id);
			if(patientsOptional.isPresent()) {
				patientRepo.deleteById(id);
			
			}
			else {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
			}
			
		}
}			


