package org.jsp.adminbusapp.dao;

import java.util.Optional;

import org.jsp.adminbusapp.dto.Admin;
import org.jsp.adminbusapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}


	public Optional<Admin> findById(int id) {
		return adminRepository.findById(id);
	}
	
	public Optional<Admin> verifyByPhone(long phone , String password) {
		return adminRepository.verifyByPhone(phone, password);
	}
	
	
	public Optional<Admin> verifyByEmail(String email , String password) {
		return adminRepository.verifyByEmail(email, password);
	}

}
