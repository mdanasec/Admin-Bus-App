package org.jsp.adminbusapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.adminbusapp.dto.Bus;
import org.jsp.adminbusapp.repository.AdminRepository;
import org.jsp.adminbusapp.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {

	@Autowired
	private BusRepository busRepository;

	public Bus saveBus(Bus bus) {
		return busRepository.save(bus);
	}
	
	public Optional<Bus> findById(int id) {
		return busRepository.findById(id);
	}

	public List<Bus> findByDateOfDeprature(String dateOfDeprature) {
		return busRepository.findByDateOfDeprature(dateOfDeprature);
	}

	public Optional<Bus> findByBusNumber(int busNumber) {
		return busRepository.findByBusNumber(busNumber);
	}

	public Optional<Bus> findBusByLocation(String dateOfDeprature, String fromLocation, String toLocation) {
		return busRepository.findBusByLocation(dateOfDeprature, fromLocation, toLocation);
	}

}
