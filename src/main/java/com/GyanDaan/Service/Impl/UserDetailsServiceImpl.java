package com.GyanDaan.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GyanDaan.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired    
	private UserServiceImpl userserviceImpl; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userserviceImpl.getUser(username);
		if(user==null) {
			System.out.println("No user found");
			throw new UsernameNotFoundException("NO user found"+username );
		}
		return user;
	}

}
