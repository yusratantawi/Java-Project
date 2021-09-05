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

import com.htu.project.models.Reservation;
import com.htu.project.services.ReservationService;

@RestController
public class ReservationController {
	
@Autowired
private ReservationService reservationService;

@GetMapping(value="/reservation")
public @ResponseBody List<Reservation> getAllReservations(  ) {
	return reservationService.getAllReservations();
}

@GetMapping(value="/reservation/{id}")
public @ResponseBody Reservation getReservationById( @PathVariable Integer id ) {
	return reservationService.getReservationById(id);
}

@GetMapping(value = "/patients/{id}/reservation")
public @ResponseBody List<Reservation> getReservationsByPatientId(@PathVariable Integer id ) {
	return reservationService.getReservationByPatient(id);
}


@PostMapping (value="/patients/{id}/reservation")
public @ResponseBody Reservation createReservationForPatient(@RequestBody Reservation reservation ,@PathVariable Integer id){
	
	return reservationService.createReservationForPatient(id, reservation);
	
}

@PutMapping (value="/patients/{id}/reservation")
public @ResponseBody Reservation updateReservationForPatient(@PathVariable Integer id,@RequestBody Reservation reservation ){
	
	return reservationService.updateReservationForPatient(id, reservation);
	
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping(value = "/patients/{id}/reservation")
public void deleteReservation(@PathVariable Integer id) {
	reservationService.deleteReservation(id);
}

}
