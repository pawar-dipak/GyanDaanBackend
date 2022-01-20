package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.GyanDaan.entities.teacher.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Long>  {
	//finding users with desired skills
	List<Skills> findBySname(String skill);
	
	//finding all skills of user
	List<Skills> findBySusername(String username);

}
