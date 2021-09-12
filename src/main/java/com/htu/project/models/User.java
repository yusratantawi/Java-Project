package com.htu.project.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String  userName;
	private String userPassword;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer user_id) {
		this.userId = user_id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user_name) {
		this.userName = user_name;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String user_password) {
		this.userPassword = user_password;
	}
	
	public User(Integer user_id, String user_name, String user_password	) {
		this.userId = user_id;
		this.userName = user_name;
		this.userPassword = user_password;
	}

	public User() {
		
	}

	
}
