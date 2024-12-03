package com.jsp.login.service;

import com.jsp.login.entity.User;

public interface LoginService {
	User singup(User u);
	String login(String value,String password);
}
