package com.GyanDaan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GyanDaan.Service.MessagesService;
import com.GyanDaan.Service.PersonalMeetingsService;
import com.GyanDaan.Service.SkillsService;
import com.GyanDaan.Service.StudentMeetingsService;
import com.GyanDaan.Service.TimeManagerService;

import com.GyanDaan.Service.UserService;
import com.GyanDaan.entities.User;
import com.GyanDaan.entities.Messages.Messages;
import com.GyanDaan.entities.teacher.PersonalMeetings;
import com.GyanDaan.entities.teacher.Skills;
import com.GyanDaan.entities.teacher.TimeManager;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private UserService userService;
	@Autowired
	private SkillsService skillsService;
	
	@Autowired
	private TimeManagerService timeManagerService;
	
	@Autowired
	private PersonalMeetingsService personalMeetingsService;
	@Autowired
	private StudentMeetingsService studentMeetingsService;
	
	@Autowired
	private  MessagesService  messagesService;
	
	
	
	/*****     Skill Controller     *****/
	
	@PostMapping("/skills")
	public void addSkill(@RequestBody Skills skill) {
		List<String> users = this.skillsService.getUserWithSkill(skill.getSname());
		for(String u:users) {
		   if(u.equals(skill.getSusername())) {
			   return;
		   }
		}
		this.skillsService.addSkill(skill);
		
	}
	//get all the users with "skill"
	@GetMapping("/skills/s={skill}")
	public List<String> getUserWithSkill(@PathVariable("skill") String skill ){
		return this.skillsService.getUserWithSkill(skill);
	}
	
	
	//get all the skills of user
	@GetMapping("/skills/u={username}")
	public List<String> getUserSkills(@PathVariable("username") String username ){
		return this.skillsService.getUserSkills(username);
	}
	
	
	  
	//*****************  Meeting Controllers *****//
	
	@PostMapping("/Meetings")
	public void addMeeting(@RequestBody TimeManager timeManager) {
			this.timeManagerService.createMeeting(timeManager);
	}
	
	
	//get  Filtered meeting by topic name
	@GetMapping("/Meetings/{topic}")
	public List<TimeManager> getMeetings(@PathVariable("topic") String topic ){
		return this.timeManagerService.getUserMeetings(topic);
	}
	
	@GetMapping("/Meetings")
	public List<TimeManager> getAllMeeting(){
		return this.timeManagerService.getAllMeeting();
	}
	@GetMapping("/Meetings/u={username}")
	public List<TimeManager> getAllTeacherMeeting(@PathVariable("username") String username){
		return this.timeManagerService.getAllTeacherMeeting(username);
	}
	
	@DeleteMapping("/Meetings/{id}")
	public void deleteMeetings(@PathVariable("id") String id) {
		 this.timeManagerService.deleteMeeting(Long.parseLong(id)); 
		
	}
	
	
	
	
	
	
	//***************** Personal Meeting Controllers *****//
	
		@PostMapping("/PersonalMeetings")
		public void addMeeting(@RequestBody PersonalMeetings personalMeetings) {
				this.personalMeetingsService.createMeeting(personalMeetings);
				this.studentMeetingsService.savePersonalMeeting(personalMeetings);
		}
		
		
		//get  Filtered meeting by topic name
		@GetMapping("/PersonalMeetings/{topic}")
		public List<PersonalMeetings> getPersonalMeetings(@PathVariable("topic") String topic ){
			return this.personalMeetingsService.getUserMeetingsByTopic(topic);
		}
		
		@GetMapping("/PersonalMeetings/u={username}")
		public List<PersonalMeetings> getAllPersonalMeetings(@PathVariable("username") String username){
			return this.personalMeetingsService.getAllMeetingofTeacher(username);
		}
		
		@DeleteMapping("/PersonalMeetings/{id}")
		public void deletePersonalMeetings(@PathVariable("id") String id) {
			 this.personalMeetingsService.deleteMeeting(Long.parseLong(id)); 
			
		}
	
		
	
	
	
	
	
}
