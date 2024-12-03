package com.jsp.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.login.entity.User;

public interface LoginDb extends JpaRepository<User	, String> {
	
	@Query(nativeQuery = true,value = "select * from user where user_id=?1 or email=?2")
	User login(String val1,String val2);

}
