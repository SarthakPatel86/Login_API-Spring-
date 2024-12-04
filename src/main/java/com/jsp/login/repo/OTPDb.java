package com.jsp.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.login.entity.OTP;

public interface OTPDb extends JpaRepository<OTP, String>{
	OTP findByOtp(int otp);

}
