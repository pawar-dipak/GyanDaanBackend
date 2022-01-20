package com.GyanDaan.Service.Impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.PersonalMeetingsRepository;
import com.GyanDaan.Repo.TimeManagerRepository;
import com.GyanDaan.Service.TimeManagerService;
import com.GyanDaan.entities.teacher.PersonalMeetings;
import com.GyanDaan.entities.teacher.TimeManager;

@Service
public class TimeManagerServiceImpl implements TimeManagerService {
	
	@Autowired
	public TimeManagerRepository timeManagerRepository;
	
	
	
	
	public void createMeeting(TimeManager timeManager) {
		this.timeManagerRepository.save(timeManager);
	}
	public void updateMeeting(TimeManager timeManager) {
		TimeManager tm =(TimeManager) this.timeManagerRepository.getById(timeManager.getTid());
		if(timeManager.gettDate()!=null) {
			tm.settDate(timeManager.gettDate());
		}
		if(timeManager.gettDescription()!=null) {
			tm.settDescription(timeManager.gettDescription());
		}
		if(timeManager.gettLink()!=null) {
			tm.settLink(tm.gettLink());
		}
		if(timeManager.gettTime()!=null) {
			tm.settTime(timeManager.gettTime());
		}
		if(timeManager.gettTopic()!=null) {
			tm.settTopic(timeManager.gettTopic());
		}
		
		this.timeManagerRepository.save(tm);
		
		
	}
	
	public void deleteMeeting(Long tid) {
		 this.timeManagerRepository.deleteById(tid);
	}
	
	@Override
	public List<TimeManager> getUserMeetings(String topic) {
		
		return this.timeManagerRepository.findBytTopic(topic);
	}
	
	public List<TimeManager> getAllMeeting(){
		return this.timeManagerRepository.findAll();
	}
	
	//getting all the meetings of teacher including personal meeting
	@Override
	public List<TimeManager> getAllTeacherMeeting(String username){
		
		return this.timeManagerRepository.findBytUsername(username);
	}
	
	
}
