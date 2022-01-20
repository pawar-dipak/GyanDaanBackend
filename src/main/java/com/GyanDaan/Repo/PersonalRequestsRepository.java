package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GyanDaan.entities.Requests.PersonalRequests;

public interface PersonalRequestsRepository extends JpaRepository<PersonalRequests, Long> {
	List<PersonalRequests> findByrTeacherUsername(String username);
	//List<PersonalRequests> findByrUsernameAndrTopic(String username,String topic);
	
	@Query(value = "SELECT DISTINCT r_topic FROM personal_requests" , nativeQuery = true)
	List<String> selectDistinct();
	
	List<PersonalRequests> findByrUsername(String username);
}
