package com.htu.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htu.project.models.Reservation;

@Repository
public interface ReservationRepo extends CrudRepository <Reservation , Integer>{
	public List<Reservation> findAll(); 
	public List<Reservation> findAllByPatientPatientId(Integer id);
	
}
