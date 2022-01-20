package com.GyanDaan.Service;

import java.util.Set;

import com.GyanDaan.entities.User;
import com.GyanDaan.entities.UserRoles;

public interface UserService {
	
	//Create User
	
	public User createUser(User user, Set<UserRoles> userRoles) throws Exception;
	
	//getting User
	public User getUser(String email);

	//deleting user
	public void deleteUser(String email);
	
	//updating User
	public User updateUser(String email,User user);
	
}
