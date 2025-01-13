package org.jsp.adminbusapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private int busNumber;
	@Column(nullable = false)
	private String dateOfDeprature;
	@Column(nullable = false)
	private int noOfSeat;
	@Column(nullable = false)
	private double costPerSeat;
	@Column(nullable = false)
	private String fromLocation;
	@Column(nullable = false)
	private String toLocation;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public String getDateOfDeprature() {
		return dateOfDeprature;
	}

	public void setDateOfDeprature(String dateOfDeprature) {
		this.dateOfDeprature = dateOfDeprature;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public double getCostPerSeat() {
		return costPerSeat;
	}

	public void setCostPerSeat(double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	@JsonIgnore
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
