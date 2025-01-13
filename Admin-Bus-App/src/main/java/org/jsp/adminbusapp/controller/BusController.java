package org.jsp.adminbusapp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.adminbusapp.dto.Bus;
import org.jsp.adminbusapp.dto.ResponseStructure;
import org.jsp.adminbusapp.service.BusService;
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
public class BusController {
	@Autowired
	private BusService busService;

	@PostMapping("/bus/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus, @PathVariable int admin_id) {
		return busService.saveBus(bus, admin_id);
	}
	
	@PutMapping("/bus/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus bus, @PathVariable int admin_id) {
		return busService.updateBus(bus, admin_id);
	}

	@GetMapping("/bus/findById/{id}")
	public ResponseEntity<ResponseStructure<Optional<Bus>>> saveBus(@PathVariable int id) {
		return busService.findById(id);
	}

	@GetMapping(value = "/bus/dateOfDep")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateOfDeprature(@RequestParam String dateOfDeprature) {
		return busService.findByDateOfDeprature(dateOfDeprature);
	}

	@GetMapping(value = "/bus/busNum/{busNumber}")
	public ResponseEntity<ResponseStructure<Optional<Bus>>> findByBusNumber(@PathVariable int busNumber) {
		return busService.findByBusNumber(busNumber);
	}

	@GetMapping(value = "/bus/busLoc")
	public ResponseEntity<ResponseStructure<Optional<Bus>>> findBusByLocation(@RequestParam String dateOfDeprature,
			@RequestParam String fromLocation, @RequestParam String toLocation) {
		
		return busService.findBusByLocation(dateOfDeprature, fromLocation, toLocation);
	}

}
