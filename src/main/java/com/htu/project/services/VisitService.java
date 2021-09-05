package com.htu.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.project.models.Patients;
import com.htu.project.models.Visits;
import com.htu.project.repositories.VisitRepo;

@Service 
public class VisitService {
@Autowired
private VisitRepo visitRepo;
@Autowired
private PatientService patientService;

public  Visits getVisitById( Integer id ) {
	Optional<Visits> visitOptional = visitRepo.findById(id);
	if(visitOptional.isPresent()) {
		return visitOptional.get();
		
	}
	throw new ResponseStatusException(
			  HttpStatus.NOT_FOUND, "entity not found"
			);
	
}

public  List<Visits> getAllVisits() {
	return visitRepo.findAll();
}

public  List<Visits> getVisitsByPatient(Integer id){
	return visitRepo.findAllByPatientPatientId(id);
}


public Visits createVisitsForPatient(Integer PatientId,Visits visit) {
	
	Patients patient =patientService.getPatientById(PatientId);
	visit.setPatient(patient);
	return visitRepo.save(visit);
	
}


public Visits updateVisitsForPatient (Integer id , Visits visit) {
	  Optional<Visits> visitOptional = visitRepo.findById(id);
			if(visitOptional.isPresent()) {
				Visits visitObj = visitOptional.get();
				visitObj.setVisitDate(visit.getVisitDate());
				visitObj.setVisitDiagnosis(visit.getVisitDiagnosis());
				visitObj.setVisitReasons(visit.getVisitReasons());
				visitObj.setVisitNotes(visit.getVisitNotes());
				visitRepo.save(visitObj);
				return visitObj;
			}
			
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
			
	

public void deleteVisit(Integer PatientId) {
	Optional<Visits> visitOptional = visitRepo.findById(PatientId);
	if(visitOptional.isPresent()) {
		visitRepo.deleteById(PatientId);
		}
	else {
		
		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "entity not found"
				);
		
	}
}
}
