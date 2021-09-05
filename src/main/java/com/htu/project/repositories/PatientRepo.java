package com.htu.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.htu.project.models.Patients;



public interface PatientRepo extends CrudRepository <Patients , Integer >{
	public List<Patients> findAll(); 

}
