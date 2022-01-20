package com.GyanDaan.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.SkillsRepository;
import com.GyanDaan.Repo.UserRepository;
import com.GyanDaan.Service.SkillsService;
import com.GyanDaan.entities.User;
import com.GyanDaan.entities.teacher.Skills;

@Service
public class SkillsServiceImpl implements SkillsService {
	
	@Autowired
	private SkillsRepository skillsRepository;
	@Autowired
	private UserRepository userRepository;
	//adding skill to database
	@Override
	public void addSkill(Skills skill) {
		this.skillsRepository.save(skill);
		
	}
	
	//getting user from skill
	@Override
	public List<String> getUserWithSkill(String skill) {
		
		List<String> ls = new ArrayList<>();
		List<Skills> sk = this.skillsRepository.findBySname(skill);
		for(Skills s:sk) {
			String email = s.getSusername();
			ls.add(email);
		}
		
		return ls;
	}
	
	@Override
	public List<String> getUserSkills(String username){
		List<String> ls = new ArrayList<>();
		List<Skills> sk = this.skillsRepository.findBySusername(username);
		for(Skills skill:sk) {
			ls.add(skill.getSname());
		}
		return ls;
		
	}
	

}
