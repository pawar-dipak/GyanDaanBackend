package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GyanDaan.entities.teacher.TimeManager;

public interface TimeManagerRepository extends JpaRepository<TimeManager, Long> {
	
	
	List<TimeManager> findBytUsername(String username);
	
	List<TimeManager> findBytTopic(String topic);
	List<TimeManager> findAll();

}
