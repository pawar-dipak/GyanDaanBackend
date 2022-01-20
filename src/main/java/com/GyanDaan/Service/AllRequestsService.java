package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.Requests.AllRequests;

public interface AllRequestsService {
	
	
	public void addAllReq(AllRequests allRequests);
	
	//getting all requests all topics 
	public List<AllRequests> getAllReq();
	
	
	//getting all request of specific topic 
	public List<AllRequests> getAllReqSpecific(String topic);
	
	//getting all request by username
	public List<AllRequests> getAllReqbyUsername(String username);
	
	//delete request by id
	public void deleteById(Long id);

}
