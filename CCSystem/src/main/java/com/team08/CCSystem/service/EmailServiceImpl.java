package com.team08.CCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailServiceImpl {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	

    public void sendMail(String toEmail, String subject, String message) {
    	
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        //simpleMailMessage.setFrom("mrsisa.t8@gmail.com");

        javaMailSender.send(simpleMailMessage);
    }
	
}
