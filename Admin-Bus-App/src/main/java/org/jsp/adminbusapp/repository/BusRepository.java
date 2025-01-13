package org.jsp.adminbusapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.adminbusapp.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer> {

	@Query("SELECT b FROM Bus b WHERE b.dateOfDeprature=?1")
	public List<Bus> findByDateOfDeprature(String dateOfDeprature);

	@Query("SELECT b FROM Bus b WHERE b.busNumber=?1")
	public Optional<Bus> findByBusNumber(int busNumber);

	@Query("SELECT b FROM Bus b WHERE b.dateOfDeprature = ?1 AND b.fromLocation = ?2 AND b.toLocation = ?3")
	public Optional<Bus> findBusByLocation(String dateOfDeprature, String fromLocation, String toLocation);

}
