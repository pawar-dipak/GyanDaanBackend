package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GyanDaan.entities.StudentMeetings;

public interface StudentMeetingsRepository extends JpaRepository<StudentMeetings, Long> {
	
	List<StudentMeetings> findBytStudentUsername(String username);
}
