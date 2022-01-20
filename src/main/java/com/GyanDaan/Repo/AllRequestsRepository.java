package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GyanDaan.entities.Requests.AllRequests;

public interface AllRequestsRepository extends JpaRepository<AllRequests, Long> {

	List<AllRequests> findByrTopic(String topic);
	List<AllRequests> findByrUsername(String username);
	
}
