package com.jsp.login.serviceimpln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.login.entity.OTP;
import com.jsp.login.entity.User;
import com.jsp.login.exception.InvalidCredentialException;
import com.jsp.login.exception.InvalidOtpException;
import com.jsp.login.repo.LoginDb;
import com.jsp.login.repo.OTPDb;
import com.jsp.login.service.LoginService;

@Service
public class LoginServiceImpln implements LoginService {

	@Autowired
	LoginDb loginDb;

	@Autowired
	OTPDb otpDb;

	@Autowired
	JavaMailSender javaMailSender;

	BCryptPasswordEncoder pass = new BCryptPasswordEncoder();

	public String sendOtp(String email, String UserId) {
		SimpleMailMessage mail = new SimpleMailMessage();
		int otp = (int) (Math.random() * 1000000);
		System.out.println("Otp : " + otp);
		mail.setFrom("sarthakpranav47@gmail.com");
		mail.setTo(email);
		mail.setSubject("Otp For Login");
		mail.setText("Please find Otp below \n Otp : " + otp + "\n Please Dont share with anyone");
		javaMailSender.send(mail);
		otpDb.save(new OTP(UserId, otp));
		return "Otp Send Through Email";
	}

	@Override
	public User singup(User u) {
		u.setPassword(pass.encode(u.getPassword()));
		return loginDb.save(u);
	}

	@Override
	public String login(String value, String password) {
		User u1 = loginDb.login(value, value);
		if (u1 != null) {
			if (pass.matches(password, u1.getPassword())) {
				return sendOtp(u1.getEmail(), u1.getUserId());
			} else {
				throw new InvalidCredentialException();
			}

		} else {
			throw new InvalidCredentialException();
		}
	}

	@Override
	public User verifyOtp(int otp) {

		OTP o1 = otpDb.findByOtp(otp);
		if (o1 != null) {
			return loginDb.findById(o1.getUid()).orElseThrow(() -> new InvalidCredentialException());
		} else {
			throw new InvalidOtpException();
		}

	}
}
