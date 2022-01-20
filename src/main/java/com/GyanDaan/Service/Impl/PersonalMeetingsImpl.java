package com.GyanDaan.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.PersonalMeetingsRepository;
import com.GyanDaan.Repo.TimeManagerRepository;
import com.GyanDaan.Service.PersonalMeetingsService;
import com.GyanDaan.entities.teacher.PersonalMeetings;
import com.GyanDaan.entities.teacher.TimeManager;

@Service
public class PersonalMeetingsImpl implements PersonalMeetingsService {
	
	@Autowired
	private PersonalMeetingsRepository personalMeetingsRepository;
	@Autowired
	private TimeManagerRepository timeManagerRepository;
	
	@Override
	public void createMeeting(PersonalMeetings personalMeetings) {
	this.personalMeetingsRepository.save(personalMeetings);
	}
	
	//delete later
	@Override
	public void addtoPersonalMeeting(String id,String username) {
		long Id = Long.parseLong(id);
		TimeManager timeManager = this.timeManagerRepository.findById(Id).get();
		PersonalMeetings personalMeetings = new PersonalMeetings();
		personalMeetings.settStudentUsername(username);
		personalMeetings.settUsername(timeManager.gettUsername());
		personalMeetings.settDate(timeManager.gettDate());
		personalMeetings.settDescription(timeManager.gettDescription());
		personalMeetings.settLink(timeManager.gettLink());
		personalMeetings.settTime(timeManager.gettTime());
		personalMeetings.settTopic(timeManager.gettTopic());
		
		
	     this.personalMeetingsRepository.save(personalMeetings);
	}

	@Override
	public void updateMeeting(PersonalMeetings personalMeetings) {
		// TODO Auto-generated method stub
		PersonalMeetings tm =(PersonalMeetings) this.personalMeetingsRepository.getById(personalMeetings.getTid());
		if(personalMeetings.gettDate()!=null) {
			tm.settDate(personalMeetings.gettDate());
		}
		if(personalMeetings.gettDescription()!=null) {
			tm.settDescription(personalMeetings.gettDescription());
		}
		if(personalMeetings.gettLink()!=null) {
			tm.settLink(tm.gettLink());
		}
		if(personalMeetings.gettTime()!=null) {
			tm.settTime(personalMeetings.gettTime());
		}
		if(personalMeetings.gettTopic()!=null) {
			tm.settTopic(personalMeetings.gettTopic());
		}
		
		this.personalMeetingsRepository.save(tm);
		
		
		
	}

	@Override
	public void deleteMeeting(Long tid) {
		// TODO Auto-generated method stub
		 this.personalMeetingsRepository.deleteById(tid);
		
	}

	@Override
	public List<PersonalMeetings> getUserMeetingsByTopic(String topic) {
		// TODO Auto-generated method stub
		 return this.personalMeetingsRepository.findBytTopic(topic);
	}

	@Override
	public List<PersonalMeetings> getAllMeetingofTeacher(String username) {
		// TODO Auto-generated method stub
		return this.personalMeetingsRepository.findBytUsername(username);
	}

	@Override
	public List<PersonalMeetings> getAllMeetingofStudent(String username) {
		// TODO Auto-generated method stub
		return this.personalMeetingsRepository.findBytStudentUsername(username);
	}


//	@Override
//	public List<PersonalMeetings> getAllMeetings() {
//		// TODO Auto-generated method stub
//		return this.personalMeetingsRepository.findAll();
//	}

}
