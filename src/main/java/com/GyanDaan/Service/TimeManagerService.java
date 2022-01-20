package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.teacher.TimeManager;



public interface TimeManagerService {

	public void createMeeting(TimeManager timeManager);
	public void updateMeeting(TimeManager timeManager);
	public void deleteMeeting(Long tid);
	public List<TimeManager> getUserMeetings(String topic);
	public List<TimeManager> getAllMeeting();
	
	public List<TimeManager> getAllTeacherMeeting(String username);
	
}
