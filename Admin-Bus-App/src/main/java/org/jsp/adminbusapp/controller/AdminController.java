package org.jsp.adminbusapp.controller;

import java.util.Optional;

import org.jsp.adminbusapp.dto.Admin;
import org.jsp.adminbusapp.dto.ResponseStructure;
import org.jsp.adminbusapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping(value = "/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	
	@GetMapping(value = "/admin/id/{id}")
	public ResponseEntity<ResponseStructure<Optional<Admin>>> findById(@PathVariable int id){
		return adminService.findById(id);
	}
	
	@GetMapping(value = "/admin/phone")
	public ResponseEntity<ResponseStructure<Optional<Admin>>> verifyByPhone(@RequestParam long phone ,@RequestParam String password) {
		return adminService.verifyByPhone(phone, password);
	}

	@GetMapping(value = "/admin/email")
	public ResponseEntity<ResponseStructure<Optional<Admin>>> verifyByEmail(@RequestParam String email ,@RequestParam String password) {
		return adminService.verifyByEmail(email, password);
	}
}
