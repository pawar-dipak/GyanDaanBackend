package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.Requests.AcceptedRequests;

public interface AcceptedRequestService {
	
	public void addtoAcceptedRequest(String id,String username);
	
	//get all accepted requests of teacher/mentor
	public List<AcceptedRequests> getAllAcceptedRequests(String username);
	
	//get all accepted requests of student
	public List<AcceptedRequests> getAllAcceptedRequestsUser(String username);
	
	//add personal request to accepted request
	public void addPersonalReqtoAcceptedRequest(String id, String username);

}
