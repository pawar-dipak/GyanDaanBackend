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

import com.GyanDaan.Service.AcceptedRequestService;
import com.GyanDaan.Service.AllRequestsService;
import com.GyanDaan.Service.PersonalRequestsService;
import com.GyanDaan.Service.UserService;
import com.GyanDaan.entities.Requests.AcceptedRequests;
import com.GyanDaan.entities.Requests.AllRequests;
import com.GyanDaan.entities.Requests.PersonalRequests;

@RestController
@RequestMapping("/Request")
public class RequestController {
	
	@Autowired
	private AllRequestsService allRequestsService;
	@Autowired
	private PersonalRequestsService personalRequestsService;
	@Autowired
	private AcceptedRequestService acceptedRequestService;
	
	
	@Autowired
	private UserService userService;
	
/////** ALLREQUEST MAPPINGS **/////
	
	@PostMapping("/AllRequest")
	public void addReq(@RequestBody AllRequests allRequests) {
		this.allRequestsService.addAllReq(allRequests);
	}
	
	@GetMapping("/AllRequest")
	public List<AllRequests> getAllReq(){
		return this.allRequestsService.getAllReq();
	}
	
	@GetMapping("/AllRequest/{topic}")
	public List<AllRequests> getAllReqSpecific(@PathVariable("topic") String topic){
		return this.allRequestsService.getAllReqSpecific(topic);
	}
	
	@GetMapping("/AllRequest/u={username}")
	public List<AllRequests> getAllReqbyUsername(@PathVariable("username") String username){
		return this.allRequestsService.getAllReqbyUsername(username);
	}
	
	@DeleteMapping("/AllRequest/{id}")
	public void deleteRequest(@PathVariable("id") String id) {
		this.allRequestsService.deleteById(Long.parseLong(id));
	}
	
	
/////*** Personal Requests Mapping ***/////
	
	@PostMapping("/PersonalRequest")
	public void addReq(@RequestBody PersonalRequests personalRequests) {
		this.personalRequestsService.addPersonalReq(personalRequests);
	}
	//all request to teacher
	@GetMapping("/PersonalRequest/{username}")
	public List<PersonalRequests> getAllPersonalRequests(@PathVariable("username") String username) {
		return this.personalRequestsService.getAllPersonalReq(username);
	}
	//all request made by student
	@GetMapping("/PersonalRequest/u={username}")
	public List<PersonalRequests> getAllPersonalRequestsOfStudent(@PathVariable("username") String username) {
		return this.personalRequestsService.getAllPersonalReqOfStudent(username);
	}
	
	@DeleteMapping("/PersonalRequest/{id}")
	public void deletePersonalRequest(@PathVariable("id") String id) {
		this.personalRequestsService.deleteById(Long.parseLong(id));
	}
	
	@GetMapping("/PersonalRequest/{username}/{topic}")
	public List<PersonalRequests> getSpecificPersonalRequest(@PathVariable("username") String username,@PathVariable("topic") String topic){
		return this.personalRequestsService.getSpecificPersonalReq(username, topic);
		
	}
	
	@GetMapping("/PersonalRequest/{username}/distinct")
	public List<String> distincttopic(@PathVariable("username") String username){
		return this.personalRequestsService.selectDistinct();
	}
/////*** Accepted Requests Mapping ***/////	
	@PostMapping("/AcceptedRequest/{id}/{username}")
	public void addReq(@PathVariable("id") String id,@PathVariable("username") String username ) {
		this.acceptedRequestService.addtoAcceptedRequest(id, username);
	}
	
	@PostMapping("/PerReqtoAcceptedRequest/{id}/{username}")
	public void addPersonalReq(@PathVariable("id") String id,@PathVariable("username") String username ) {
		this.acceptedRequestService.addPersonalReqtoAcceptedRequest(id, username);
	}
	
	//get all accepted requests of teacher
	@GetMapping("/AcceptedRequest/{username}")
	public List<AcceptedRequests> getAcceptedRequest(@PathVariable("username") String username) {
		return this.acceptedRequestService.getAllAcceptedRequests(username);
	}
	
	//get all accepted requests of student/user
	@GetMapping("/student/AcceptedRequest/{username}")
	public List<AcceptedRequests> getAcceptedRequestUser(@PathVariable("username") String username) {
		return this.acceptedRequestService.getAllAcceptedRequestsUser(username);
	}
	
}