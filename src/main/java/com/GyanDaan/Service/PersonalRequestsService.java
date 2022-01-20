package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.Requests.PersonalRequests;

public interface PersonalRequestsService {
	
	
	public void addPersonalReq(PersonalRequests personalRequests);
	
	public List<PersonalRequests> getAllPersonalReq(String Username);
	
	public List<PersonalRequests> getSpecificPersonalReq(String username,String topic);
	
	public List<String> selectDistinct();
	
	public List<PersonalRequests> getAllPersonalReqOfStudent(String Username);

	public void deleteById(Long id);
}
