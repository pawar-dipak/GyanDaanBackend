package com.GyanDaan.Service;

import java.util.List;

import com.GyanDaan.entities.Messages.Messages;

public interface MessagesService {
	
	public void addMessage(Messages messages);
	
	
	public List<Messages> getAllMessages(String username);
	
	public void deleteMessage(long id);
	
	public List<String> findUsername(String username);

	public List<Messages> getMessages(String username,String replytoUsername);
}
