package com.htu.project.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.htu.project.models.Visits;

public interface VisitRepo extends CrudRepository<Visits , Integer> {
	public List<Visits> findAll(); 
	public List<Visits> findAllByPatientPatientId(Integer id);

}
