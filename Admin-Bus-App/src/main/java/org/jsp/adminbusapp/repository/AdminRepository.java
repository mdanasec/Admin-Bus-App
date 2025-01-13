package org.jsp.adminbusapp.repository;

import java.util.Optional;

import org.jsp.adminbusapp.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("SELECT a FROM Admin a WHERE a.phone=?1 AND a.password=?2")
	public Optional<Admin> verifyByPhone(long phone , String password);
	
	@Query("SELECT a FROM Admin a WHERE a.email=?1 AND a.password=?2")
	public Optional<Admin> verifyByEmail(String email , String password);
}
