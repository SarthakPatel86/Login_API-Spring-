package com.jsp.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OTP {

	@Id
	String uid;
	int otp;

	public OTP(String uid, int otp) {
		super();
		this.uid = uid;
		this.otp = otp;
	}

	public OTP() {
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

}
