package com.bookmymovie.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Admin;
import com.bookmymovie.app.repository.AdminRepository;
import com.bookmymovie.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public boolean isAdmin(Admin admin) {
		if (adminRepository.existsById(admin.getAdminid())) {
			Admin currentadmin = adminRepository.findById(admin.getAdminid()).get();
			if (currentadmin.getPassword().equals(admin.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}		
	}
}
