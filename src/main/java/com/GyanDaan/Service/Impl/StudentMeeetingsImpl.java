package com.GyanDaan.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.StudentMeetingsRepository;
import com.GyanDaan.Repo.TimeManagerRepository;
import com.GyanDaan.Service.StudentMeetingsService;
import com.GyanDaan.entities.StudentMeetings;
import com.GyanDaan.entities.teacher.PersonalMeetings;
import com.GyanDaan.entities.teacher.TimeManager;

@Service
public class StudentMeeetingsImpl implements StudentMeetingsService {

	@Autowired
	private StudentMeetingsRepository studentMeetingsRepository;
	@Autowired
	private TimeManagerRepository timeManagerRepository;
	
	@Override
	public void saveMeeting(String id,String username) {
		long Id = Long.parseLong(id);
		TimeManager timeManager = this.timeManagerRepository.findById(Id).get();
		StudentMeetings studentMeetings = new StudentMeetings(timeManager,username);
		this.studentMeetingsRepository.save(studentMeetings);
	}
	@Override
	public void savePersonalMeeting(PersonalMeetings personalMeetings) {
		
		StudentMeetings studentMeetings = new StudentMeetings(personalMeetings);
		this.studentMeetingsRepository.save(studentMeetings);
	}
	
	@Override
	public List<StudentMeetings> getMeetings(String username){
		return this.studentMeetingsRepository.findBytStudentUsername(username);
	}
}
