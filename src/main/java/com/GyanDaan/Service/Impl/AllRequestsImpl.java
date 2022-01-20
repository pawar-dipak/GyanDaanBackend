package com.GyanDaan.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.AllRequestsRepository;
import com.GyanDaan.Service.AllRequestsService;
import com.GyanDaan.entities.Requests.AllRequests;

@Service
public class AllRequestsImpl implements AllRequestsService {
	
	@Autowired
	public AllRequestsRepository allRequestsRepository;

	@Override
	public void addAllReq(AllRequests allRequests) {
		this.allRequestsRepository.save(allRequests);
		
	}

	@Override
	public List<AllRequests> getAllReq() {
		return this.allRequestsRepository.findAll();
	}

	@Override
	public List<AllRequests> getAllReqSpecific(String topic) {
		return this.allRequestsRepository.findByrTopic(topic);
	}
	@Override
	public List<AllRequests> getAllReqbyUsername(String username) {
		return this.allRequestsRepository.findByrUsername(username);
	}
	
	@Override
	public void deleteById(Long id) {
		this.allRequestsRepository.deleteById(id);
	}

}
