package com.htu.project.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.project.models.User;
import com.htu.project.repositories.UserRepo;

@Service 
public class UserService {
@Autowired 
private UserRepo userRepo;

public User createUser(User user) {
	return userRepo.save(user);
	
}

public List<User> getAllUser() {
	return userRepo.findAll();
}

public  User getUserById( Integer id ) {
	Optional<User> userOptional = userRepo.findById(id);
	if(userOptional.isPresent()) {
		return userOptional.get();
		
	}
	throw new ResponseStatusException(
			  HttpStatus.NOT_FOUND, "entity not found"
			);}

	public   User updateUser (Integer userId , User user) {
		  Optional<User> userOptional = userRepo.findById(userId);
			if(userOptional.isPresent()) {
				User userObj = userOptional.get();
				userObj.setUserName(user.getUserName());
				userObj.setUserPassword(user.getUserPassword());
				userRepo.save(userObj);
				return userObj ;
												}
			
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
	
	
	public void deleteUser( Integer id) {
		Optional<User> userOptional = userRepo.findById(id);
			if(userOptional.isPresent()) {
				userRepo.deleteById(id);
		
		}
		else {
		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "entity not found"
				);
		}
		
	}
	public User getUserByUsername(String username) {
		Optional<User> userOptional = userRepo.findByUserName(username);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "User Not Found");
	}
	public boolean authenticateUser(String username,String password) {
		User user = getUserByUsername(username);
		if (user.getUserPassword().equals(password)) {
			return true;
		}
		return false;
	}
}	




