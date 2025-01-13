package org.jsp.adminbusapp.service;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.jsp.adminbusapp.dao.AdminDao;
import org.jsp.adminbusapp.dto.Admin;
import org.jsp.adminbusapp.dto.ResponseStructure;
import org.jsp.adminbusapp.exception.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setMessage("Admin saved Successfully");
		structure.setData(adminDao.saveAdmin(admin));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = adminDao.findById(admin.getId());
		if (recAdmin.isPresent()) {
			structure.setMessage("Admin updated Successfully");
			structure.setData(adminDao.saveAdmin(admin));
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
		}
		throw new AdminNotFoundException("you have entered invalid id");
	}

	public ResponseEntity<ResponseStructure<Optional<Admin>>> findById(int id) {
		ResponseStructure<Optional<Admin>> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = adminDao.findById(id);
		if (recAdmin.isPresent()) {
			structure.setMessage("admin found ");
			structure.setData(adminDao.findById(id));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Admin>>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException("invalid id");
	}

	public ResponseEntity<ResponseStructure<Optional<Admin>>> verifyByPhone(long phone, String password) {
		ResponseStructure<Optional<Admin>> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = adminDao.verifyByPhone(phone, password);
		if (recAdmin.isPresent()) {
			structure.setMessage("Login successfully ");
			structure.setData(adminDao.verifyByPhone(phone, password));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Admin>>>(structure, HttpStatus.OK);
		}

		throw new AdminNotFoundException("you have entered wrong phone or password ");

	}






	public ResponseEntity<ResponseStructure<Optional<Admin>>> verifyByEmail(String email, String password) {
		ResponseStructure<Optional<Admin>> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = adminDao.verifyByEmail(email, password);
		if (recAdmin.isPresent()) {
			structure.setMessage("Login successfully ");
			structure.setData(adminDao.verifyByEmail(email, password));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Admin>>>(structure, HttpStatus.OK);
		}

		throw new AdminNotFoundException("you have entered wrong email or password ");

	}
}
