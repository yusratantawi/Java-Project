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
import com.htu.project.models.User;
import com.htu.project.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/user")
	public @ResponseBody List<User> getAllUser() {
		return userService.getAllUser();
	}
	@GetMapping(value = "/user/{id}")
	public @ResponseBody User getUserById(@PathVariable Integer id ) {
		return userService.getUserById(id);
	}

	@PostMapping(value = "/user")
	  public User createUser(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
@PutMapping("/user/{id}")
public @ResponseBody User updateUser(@RequestBody User user,@PathVariable Integer id ) {
	return userService.updateUser(id, user);
	
}

@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping(value = "/user/{id}")
public @ResponseBody void deletepatient(@PathVariable Integer id) {
	userService.deleteUser(id);
}
}
