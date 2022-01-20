package com.GyanDaan.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.GyanDaan.GyanDaanApplication;
import com.GyanDaan.entities.Messages.Messages;

public interface MessagesRepository extends JpaRepository<Messages, Long> {
	
	List<Messages> findBymUsername(String username);
	
	List<Messages> findBymReplytoUsername(String username);
	
	
	@Query(value = "select distinct m_replyto_username from messages where m_username=?#{#username} union select distinct m_username  from gyandaan.messages where m_replyto_username=?#{#username}" , nativeQuery = true)
	List<String> distinctusername(@Param("username") String username);

	@Query(value = "select m_id  from messages where m_username=?#{#replytoUsername} and m_replyto_username=?#{#username}  union select m_id from gyandaan.messages where m_replyto_username=?#{#replytoUsername} and m_username=?#{#username} " , nativeQuery = true)
	List<String> getMessages(@Param("username") String username,@Param("replytoUsername") String replytoUsername );
}
