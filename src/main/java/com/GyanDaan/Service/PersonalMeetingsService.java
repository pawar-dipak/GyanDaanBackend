package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.teacher.PersonalMeetings;



public interface PersonalMeetingsService {
	
	public void createMeeting(PersonalMeetings personalMeetings);
	public void updateMeeting(PersonalMeetings personalMeetings);
	public void deleteMeeting(Long tid);
	public List<PersonalMeetings> getUserMeetingsByTopic(String topic);
	public List<PersonalMeetings> getAllMeetingofTeacher(String username);
	public List<PersonalMeetings> getAllMeetingofStudent(String username);
	public void addtoPersonalMeeting(String id,String username);
}
