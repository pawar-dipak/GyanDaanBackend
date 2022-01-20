package com.GyanDaan;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GyanDaan.Service.MessagesService;
import com.GyanDaan.Service.UserService;
import com.GyanDaan.Service.Impl.MessagesServiceImpl;
import com.GyanDaan.entities.Role;
import com.GyanDaan.entities.User;
import com.GyanDaan.entities.UserRoles;

@SpringBootApplication
public class GyanDaanApplication implements CommandLineRunner{
    @Autowired
	private UserService userService;
    
  
	public static void main(String[] args) {
		SpringApplication.run(GyanDaanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting Code");
//		  
		
	}

}
