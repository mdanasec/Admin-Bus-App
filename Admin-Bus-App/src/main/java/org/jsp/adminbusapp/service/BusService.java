package org.jsp.adminbusapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.adminbusapp.dao.AdminDao;
import org.jsp.adminbusapp.dao.BusDao;
import org.jsp.adminbusapp.dto.Admin;
import org.jsp.adminbusapp.dto.Bus;
import org.jsp.adminbusapp.dto.ResponseStructure;
import org.jsp.adminbusapp.exception.BusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus, int adminId) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.findById(adminId);

		if (dbAdmin.isPresent()) {
			Admin admin = dbAdmin.get();
			admin.getBus().add(bus);
			bus.setAdmin(admin);
			adminDao.saveAdmin(admin);
			Bus savedBus = busDao.saveBus(bus);
			structure.setMessage("Bus saved successfully");
			structure.setData(savedBus);
			structure.setStatusCode(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.CREATED);
		}
		throw new BusNotFoundException("Admin with id " + adminId + " not found");
	}

	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus bus, int adminId) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Bus> dbBus = busDao.findById(bus.getId());
		
		if (dbBus.isPresent()) {
			Bus recBus = dbBus.get();
			recBus.setBusNumber(bus.getBusNumber());
			recBus.setCostPerSeat(bus.getCostPerSeat());
			recBus.setDateOfDeprature(bus.getDateOfDeprature());
			recBus.setFromLocation(bus.getFromLocation());
			recBus.setToLocation(bus.getToLocation());
			recBus.setNoOfSeat(bus.getNoOfSeat());
			structure.setData(busDao.saveBus(recBus));
			structure.setMessage("Bus updated successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());

			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException("Admin with id " + adminId + " not found");
	} 

	public ResponseEntity<ResponseStructure<Optional<Bus>>> findById(int id) {
		ResponseStructure<Optional<Bus>> structure = new ResponseStructure<>();
		Optional<Bus> recBus = Optional.of(busDao.findById(id).get());
		if (recBus.isPresent()) {
			structure.setMessage("Bus Found ");
			structure.setData(busDao.findById(id));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Bus>>>(structure, HttpStatus.OK);
		} else
			throw new BusNotFoundException("you have entered invalid id ");
	}

	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateOfDeprature(String dateOfDeprature) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> recBus = busDao.findByDateOfDeprature(dateOfDeprature);
		if (recBus.size() > 0) {
			structure.setMessage("Found Busses");
			structure.setData(busDao.findByDateOfDeprature(dateOfDeprature));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException("Bus is not avlaible in this " + dateOfDeprature);
	}

	public ResponseEntity<ResponseStructure<Optional<Bus>>> findByBusNumber(int busNumber) {
		ResponseStructure<Optional<Bus>> structure = new ResponseStructure<>();
		Optional<Bus> recBus = busDao.findByBusNumber(busNumber);
		if (recBus.isPresent()) {
			structure.setMessage("Found Busses");
			structure.setData(busDao.findByBusNumber(busNumber));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException("Bus is not avlaible in this bus Number " + busNumber);
	}

	public ResponseEntity<ResponseStructure<Optional<Bus>>> findBusByLocation(String dateOfDeprature,
			String fromLocation, String toLocation) {
		ResponseStructure<Optional<Bus>> structure = new ResponseStructure<>();
		Optional<Bus> recBus = busDao.findBusByLocation(dateOfDeprature, fromLocation, toLocation);
		if (recBus.isPresent()) {
			structure.setMessage("Found Bus");
			structure.setData(busDao.findBusByLocation(dateOfDeprature, fromLocation, toLocation));
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException("Bus is not avlaible");
	}

}
