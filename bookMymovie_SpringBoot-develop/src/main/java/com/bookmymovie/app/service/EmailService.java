/**
 * 
 */
package com.bookmymovie.app.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Users;

import freemarker.template.TemplateException;

/**
 * @author Sidramesh.
 *
 */
@Service
public interface EmailService {
	
	public void signupMail(Users user) throws MessagingException, IOException, TemplateException;

}
