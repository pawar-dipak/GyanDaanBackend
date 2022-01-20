package com.GyanDaan.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GyanDaan.Repo.MessagesRepository;
import com.GyanDaan.Service.MessagesService;
import com.GyanDaan.entities.Messages.Messages;

@Service
public class MessagesServiceImpl implements MessagesService {
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	@Override
	public void addMessage(Messages messages) {
		// TODO Auto-generated method stub
		this.messagesRepository.save(messages);
		
	}

	@Override
	public List<Messages> getAllMessages(String username) {
		// TODO Auto-generated method stub
		List<Messages> ls = new ArrayList<>();
		ls.addAll(this.messagesRepository.findBymReplytoUsername(username));
		List<Messages> list = new ArrayList<>();
		list.addAll(this.messagesRepository.findBymUsername(username));
		List<Messages> allmsg = new ArrayList<>();
		int i = 0,j=0;
		while(i<ls.size()&&j<list.size()) {
			Messages m1 = ls.get(i);
			Messages m2 = list.get(j);
			if(m1.getmId()>m2.getmId()) {
				allmsg.add(m2);
				j++;
			}
			else {
				allmsg.add(m1);
				i++;
			}
		}
		while(i<ls.size()) {
			allmsg.add(ls.get(i++));
		}
		while(j<list.size()) {
			allmsg.add(list.get(j++));
		}
		
		
		
		return allmsg;
	}

	@Override
	public void deleteMessage(long id) {
		// TODO Auto-generated method stub
		this.messagesRepository.deleteById(id);
		
	}

	@Override
	public List<String> findUsername(String username){
		return this.messagesRepository.distinctusername(username);
	}
	
	@Override
	public List<Messages> getMessages(String username,String replytoUsername){
		System.out.println(this.messagesRepository.getMessages(username, replytoUsername));
		List<String> ls =  this.messagesRepository.getMessages(username, replytoUsername);
		List<Messages> msg = new ArrayList<>();
		for(String s:ls) {
			msg.add(this.messagesRepository.findById(Long.parseLong(s)).get());
		}
		return msg;
	}
}
