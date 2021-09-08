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
import com.htu.project.models.Visits;
import com.htu.project.services.VisitService;

@RestController
public class VisitController {
@Autowired
VisitService visitService;

@GetMapping (value="/visits/{id}")
public @ResponseBody Visits getVisitById( @PathVariable Integer id ) {
	return visitService.getVisitById(id);
}


@GetMapping (value="/visits")
public @ResponseBody List<Visits> getVisit(  ) {
	return visitService.getAllVisits();
}
@GetMapping(value = "/patients/{id}/visits")
public @ResponseBody List<Visits> getVisitsByPatientId(@PathVariable Integer id ) {
	return visitService.getVisitsByPatient(id);
}

@PostMapping (value="/patients/{id}/visits")
public @ResponseBody Visits createVisitsForPatient(@RequestBody Visits visit ,@PathVariable Integer id){
	
	return visitService.createVisitsForPatient(id, visit);
	
}
@PutMapping (value="/patients/{id}/visits")
public @ResponseBody Visits updateVisitsForPatient(@PathVariable Integer id,@RequestBody Visits visit ){
	
	return visitService.updateVisitsForPatient(id, visit);
	
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping(value = "/patients/{id}/visits")
public void deleteVisit(@PathVariable Integer id) {
	visitService.deleteVisit(id);
}
}