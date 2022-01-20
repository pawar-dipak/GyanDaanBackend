package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GyanDaan.entities.teacher.PersonalMeetings;


public interface PersonalMeetingsRepository extends JpaRepository<PersonalMeetings, Long> {
	
	List<PersonalMeetings> findBytTopic(String topic);
	List<PersonalMeetings> findBytUsername(String username);
	List<PersonalMeetings> findBytStudentUsername(String username);

	
}
