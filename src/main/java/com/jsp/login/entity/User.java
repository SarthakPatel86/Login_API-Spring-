package com.jsp.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	String userId;
	String uname;
	String phon;
	@Column(unique = true)
	String email;
	String password;

	public User(String userId, String uname, String phon, String email, String password) {
		super();
		this.userId = userId;
		this.uname = uname;
		this.phon = phon;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPhon() {
		return phon;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", phon=" + phon + ", email=" + email + ", password="
				+ password + "]";
	}

}
