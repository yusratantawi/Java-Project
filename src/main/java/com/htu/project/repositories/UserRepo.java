package com.htu.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.htu.project.models.User;



public interface UserRepo  extends CrudRepository <User , Integer >{
	public List<User> findAll();
	Optional<User> findByUserName(String username);

	
}
