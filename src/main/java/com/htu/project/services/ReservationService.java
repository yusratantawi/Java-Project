package com.htu.project.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.project.models.Patients;
import com.htu.project.models.Reservation;
import com.htu.project.repositories.ReservationRepo;

@Service
public class ReservationService {
@Autowired 
private ReservationRepo reservationRepo;
@Autowired 
private PatientService patientService;

	public  Reservation getReservationById( Integer id ) {
		Optional<Reservation> reservationOptional = reservationRepo.findById(id);
		if(reservationOptional.isPresent()) {
			return reservationOptional.get();
			
		}
		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "entity not found"
				);
	
	}	 
	public  List<Reservation> getAllReservations() {
		return reservationRepo.findAll();
	}
	public  List<Reservation> getReservationByPatient(Integer id){
		return reservationRepo.findAllByPatientPatientId(id);
	}
	public Reservation createReservationForPatient(Integer PatientId,Reservation reservation) {
		Patients patient =patientService.getPatientById(PatientId);
		reservation.setPatient(patient);
		return reservationRepo.save(reservation);
	}
	
	
	public Reservation updateReservationForPatient (Integer id , Reservation reservation) {
		  Optional<Reservation> reservationOptional = reservationRepo.findById(id);
				if(reservationOptional.isPresent()) {
					Reservation reservationObj = reservationOptional.get();
					
					reservationObj.setReservationVisitDate(reservation.getReservationVisitDate());
					reservationObj.setReservationVisitSlot(reservation.getReservationVisitSlot());
					reservationRepo.save(reservationObj);
					return reservationObj;
				}
				
				throw new ResponseStatusException(
						  HttpStatus.NOT_FOUND, "entity not found"
						);
			}
				
		

	public void deleteReservation(Integer PatientId) {
		Optional<Reservation> reservationOptional = reservationRepo.findById(PatientId);
		if(reservationOptional.isPresent()) {
			reservationRepo.deleteById(PatientId);
			}
		else {
			
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
			
		}
		
		
		 
	}
}
