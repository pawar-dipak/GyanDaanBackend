package com.GyanDaan.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GyanDaan.Repo.PersonalMeetingsRepository;
import com.GyanDaan.Service.MessagesService;
import com.GyanDaan.Service.PersonalMeetingsService;
import com.GyanDaan.Service.StudentMeetingsService;
import com.GyanDaan.Service.UserService;
import com.GyanDaan.entities.Role;
import com.GyanDaan.entities.StudentMeetings;
import com.GyanDaan.entities.User;
import com.GyanDaan.entities.UserRoles;
import com.GyanDaan.entities.Messages.Messages;
import com.GyanDaan.entities.teacher.PersonalMeetings;
import com.GyanDaan.entities.teacher.TimeManager;

import helper.UserFoundException;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private StudentMeetingsService studentMeetingsService;
	
	@Autowired
	private MessagesService messagesService;
	
	
	   //creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		if(this.userService.getUser(user.getEmail())!=null) {
			throw new UserFoundException();
		}
		
		
		String role1 = user.getRole();
		
		
		Role role = new Role();
		if(role1.equals("Student")) {
		role.setRoleid(1L);
		role.setRolename("Student");}
		else {
			role.setRoleid(2L);
			role.setRolename("Teacher");
		}
		//debug
		System.out.println(role1);
		//end
		
		UserRoles userRoles = new UserRoles();
		userRoles.setUser(user);
		userRoles.setRole(role);
		
		Set<UserRoles> setUserRoles = new HashSet<>();
		setUserRoles.add(userRoles);
		
		//encoding Password with brCryptEncoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		
		return this.userService.createUser(user, setUserRoles);
		
	}
	@GetMapping("/{email}")
	public User getUser(@PathVariable("email") String email) {
		return this.userService.getUser(email);
	}
	
	@DeleteMapping("/{email}")
	public void deleteUser(@PathVariable("email") String email ) {
		this.userService.deleteUser(email);
	}
	
	@PutMapping("/{email}")
	public User updateUser(@PathVariable("email") String email,@RequestBody User user) {
		
		return this.userService.updateUser(email, user);
	}
	
	
	
	
	// personal meetings of student
	
	
	@GetMapping("/PersonalMeetings/{username}")
	public List<StudentMeetings> getAllPersonalMeetings(@PathVariable("username") String username){
		return this.studentMeetingsService.getMeetings(username);
	}
	
	@PostMapping("/add-PersonalMeetings/{id}/{username}")
	public void addtoPersonalMeeting(@PathVariable("id") String id,@PathVariable("username") String username) {
		 this.studentMeetingsService.saveMeeting(id, username);
	}
	
	
	
	
	//messages Controller of Users
	
	//getting unique messagers only
	@GetMapping("/Messages/{username}")
	public List<String> getAllMessages(@PathVariable("username") String username){
		return this.messagesService.findUsername(username);
	}
	
	//getting all msgs of username
	@GetMapping("/Messages/u={username}")
	public List<Messages> AllMessages(@PathVariable("username") String username){
		return this.messagesService.getAllMessages(username);
	}
	
	@PostMapping("/Messages")
	public void addMessages(@RequestBody Messages messages) {
		this.messagesService.addMessage(messages);
	}
	
	@GetMapping("/Messages/{username}/{replytoUsername}")
	public List<Messages> getMessages(@PathVariable("username") String username,@PathVariable("replytoUsername") String replytoUsername){
		System.out.println(username+"   "+replytoUsername);
		return this.messagesService.getMessages(username, replytoUsername);
	}
	
	

}
