package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GyanDaan.entities.Requests.AcceptedRequests;



public interface AcceptedRequestRepository extends JpaRepository<AcceptedRequests, Long> {
	
	List<AcceptedRequests> findByrTeacherUsername(String username);
	List<AcceptedRequests> findByrUsername(String username);
}
