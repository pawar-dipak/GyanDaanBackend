package com.GyanDaan.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.AcceptedRequestRepository;
import com.GyanDaan.Repo.AllRequestsRepository;
import com.GyanDaan.Repo.PersonalRequestsRepository;
import com.GyanDaan.Service.AcceptedRequestService;
import com.GyanDaan.entities.Requests.AcceptedRequests;
import com.GyanDaan.entities.Requests.AllRequests;
import com.GyanDaan.entities.Requests.PersonalRequests;

@Service
public class AcceptedRequestImpl implements AcceptedRequestService {
	
	@Autowired
	private AcceptedRequestRepository acceptedRequestRepository;
	
	@Autowired
	private AllRequestsRepository allRequestsRepository;
	
	@Autowired
	private PersonalRequestsRepository personalRequestsRepository;
	

	@Override
	public void addtoAcceptedRequest(String id, String username) {
		long Id = Long.parseLong(id);
		AllRequests allRequests = this.allRequestsRepository.getById(Id);
	    AcceptedRequests acceptedRequest = new AcceptedRequests();
	    acceptedRequest.setrId(Id);
	    acceptedRequest.setrStatus("Accepted");
	    acceptedRequest.setrTopic(allRequests.getrTopic());
	    acceptedRequest.setrDescription(allRequests.getrDescription());
	    acceptedRequest.setrTeacherUsername(username);
	    acceptedRequest.setrUsername(allRequests.getrUsername());
	    acceptedRequest.setrDate(allRequests.getrDate());
	    acceptedRequest.setrTime(allRequests.getrTime());
	    this.allRequestsRepository.deleteById(Id);
	    this.acceptedRequestRepository.save(acceptedRequest);
		
	}
	@Override
	public void addPersonalReqtoAcceptedRequest(String id, String username) {
		long Id = Long.parseLong(id);
		PersonalRequests allRequests = this.personalRequestsRepository.getById(Id);
	    AcceptedRequests acceptedRequest = new AcceptedRequests();
	    acceptedRequest.setrId(Id);
	    acceptedRequest.setrStatus("Accepted");
	    acceptedRequest.setrTopic(allRequests.getrTopic());
	    acceptedRequest.setrDescription(allRequests.getrDescription());
	    acceptedRequest.setrTeacherUsername(username);
	    acceptedRequest.setrUsername(allRequests.getrUsername());
	    acceptedRequest.setrDate(allRequests.getrDate());
	    acceptedRequest.setrTime(allRequests.getrTime());
	    this.personalRequestsRepository.deleteById(Id);
	    this.acceptedRequestRepository.save(acceptedRequest);
		
	}
	
	//all accepted requests of teacher
	@Override
	public List<AcceptedRequests> getAllAcceptedRequests(String username) {
		// TODO Auto-generated method stub
		return this.acceptedRequestRepository.findByrTeacherUsername(username);
	}
	
	//all accepted requests of student
	@Override
	public List<AcceptedRequests> getAllAcceptedRequestsUser(String username) {
		// TODO Auto-generated method stub
		return this.acceptedRequestRepository.findByrUsername(username);
	}
	

}
