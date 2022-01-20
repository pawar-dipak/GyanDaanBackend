package com.GyanDaan.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.PersonalRequestsRepository;
import com.GyanDaan.Service.PersonalRequestsService;
import com.GyanDaan.entities.Requests.PersonalRequests;

@Service
public class PersonalRequestImpl implements PersonalRequestsService {
	
	@Autowired
	public PersonalRequestsRepository personalRequestsRepository;

	@Override
	public void addPersonalReq(PersonalRequests personalRequests) {
		this.personalRequestsRepository.save(personalRequests);
		
	}

	@Override
	public List<PersonalRequests> getAllPersonalReq(String Username) {
		return this.personalRequestsRepository.findByrTeacherUsername(Username);
	}
	@Override
	public List<PersonalRequests> getAllPersonalReqOfStudent(String Username) {
		return this.personalRequestsRepository.findByrUsername(Username);
	}

	@Override
	public List<PersonalRequests> getSpecificPersonalReq(String username,String topic) {
		List<PersonalRequests> ls =  this.personalRequestsRepository.findByrTeacherUsername(username);
		topic = topic.toLowerCase();
		List<PersonalRequests> pr = new ArrayList<>();
		for(PersonalRequests p:ls) {
			String t = p.getrTopic().toLowerCase();
			if(t.equals(topic)) {
				pr.add(p);
			}
		}
		return pr;
	}
	
	@Override
	public List<String> selectDistinct(){
		return this.personalRequestsRepository.selectDistinct();
	}

	@Override
	public void deleteById(Long id) {
		this.personalRequestsRepository.deleteById(id);
		
	}
	

}
