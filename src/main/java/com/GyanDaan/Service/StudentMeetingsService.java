package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.StudentMeetings;
import com.GyanDaan.entities.teacher.PersonalMeetings;


public interface StudentMeetingsService {
	
	public void saveMeeting(String id,String username);
	public void savePersonalMeeting(PersonalMeetings personalMeetings);
	public List<StudentMeetings> getMeetings(String username);
}
