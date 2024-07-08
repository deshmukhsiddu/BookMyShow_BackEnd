/**
 * 
 */
package com.bookmymovie.app.service;

import org.springframework.stereotype.Service;

import com.bookmymovie.app.entity.Admin;

/**
 * @author Sidramesh.
 *
 */
@Service
public interface AdminService {
	
	public boolean isAdmin(Admin admin);

}
