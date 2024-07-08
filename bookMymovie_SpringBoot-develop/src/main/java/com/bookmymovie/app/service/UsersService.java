package com.bookmymovie.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Users;

/**
 * @author Tanaji.
 *
 */
@Service
public interface UsersService {
	
	public List<Users> getAllUsers();
	
	public void saveUser(Users users);

	public Users getUserEmailById(String email);
	
	public void deleteUser(String email);
	
	public boolean checkExistingUser(String email);
	
	public boolean checkUserLogin(String emailid, String pass);

}
