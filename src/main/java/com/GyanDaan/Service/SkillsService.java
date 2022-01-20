package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.User;
import com.GyanDaan.entities.teacher.Skills;

public interface SkillsService {
	
	public void addSkill(Skills skill);
	
	public List<String> getUserWithSkill(String skill);
	
	public List<String> getUserSkills(String username);

//    public void deleteSkill(Skills skill);
	
	
}
