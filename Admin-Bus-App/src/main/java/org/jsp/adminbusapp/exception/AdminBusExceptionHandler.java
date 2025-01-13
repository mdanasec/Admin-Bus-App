package org.jsp.adminbusapp.exception;

import org.jsp.adminbusapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminBusExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleANFE(AdminNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData("invalid admin id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleBNFE(BusNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData("invalid Bus id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
