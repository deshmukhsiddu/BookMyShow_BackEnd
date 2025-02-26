package com.bookmymovie.app.controller;

import java.io.IOException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookmymovie.app.entity.Users;
import com.bookmymovie.app.service.EmailService;
import freemarker.template.TemplateException;


@RestController
@RequestMapping(value="/api")
public class MailController {

	@Autowired
	private EmailService mailservice;

	@GetMapping("mail/signup")
	public void signupMail(@RequestBody Users user){
		try {
			mailservice.signupMail(user);
		} catch (MessagingException | IOException | TemplateException e) {
			e.printStackTrace();
		}
	}
}
