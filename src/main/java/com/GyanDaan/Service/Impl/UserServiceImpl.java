package com.GyanDaan.Service.Impl;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.RoleRepository;
import com.GyanDaan.Repo.UserRepository;
import com.GyanDaan.Service.UserService;
import com.GyanDaan.entities.User;
import com.GyanDaan.entities.UserRoles;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
   //Creating User
	@Override
	public User createUser(User user, Set<UserRoles> userRoles) throws Exception {
		
		User local = this.userRepository.findByEmail(user.getEmail());
		
		if(local != null) {
			System.out.println("User Already present!!");
			throw new Exception("User Already Present");
			
		}else {
			for(UserRoles ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		
		
		return local;
	}

	//getting user by email
	@Override
	public User getUser(String email){
		
		return this.userRepository.findByEmail(email);
	}

	@Override
	public void deleteUser(String email) {
		
		this.userRepository.deleteById(email);
		
	}

	@Override
	public User updateUser(String email,User user) {
		User user1 = getUser(email);
		if(user.getName()!=null) {
			user1.setName(user.getName());
		}
		if(user.getPhone()!=null) {
			user1.setPhone(user.getPhone());
		}
		if(user.getPassword()!=null) {
			user1.setPassword(user.getPassword());
		}
		
		return this.userRepository.save(user1);
		
		
	}

}
