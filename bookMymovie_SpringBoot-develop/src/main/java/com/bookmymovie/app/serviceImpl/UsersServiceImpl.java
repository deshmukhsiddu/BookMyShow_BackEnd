package com.bookmymovie.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Users;
import com.bookmymovie.app.repository.UsersRepository;
import com.bookmymovie.app.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public void saveUser(Users users) {
		usersRepository.save(users);
	}

	@Override
	public Users getUserEmailById(String email) {
		return usersRepository.findById(email).get();
	}

	@Override
	public void deleteUser(String email) {
		usersRepository.deleteById(email);
	}

	@Override
	public boolean checkExistingUser(String email) {
		return usersRepository.existsById(email);
	}

	@Override
	public boolean checkUserLogin(String emailid, String pass) {
		if (checkExistingUser(emailid)) {
			Users users = getUserEmailById(emailid);
			if (users.getPassword().equals(pass)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
