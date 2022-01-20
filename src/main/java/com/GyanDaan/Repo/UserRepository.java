package com.GyanDaan.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GyanDaan.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByEmail(String email);

}
