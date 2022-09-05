package com.medplus.tourmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tourInformation")
public class TourInformation {

	@Id
	private int tourInfoId;
	@Column(name = "location", length = 25)
	private String location;
	@Column(name = "travelType")
	private String travelType;
	// tour Description : Places details
	@Column(name = "tourDescription", length = 100)
	private String tourDescription;
	@Column(name = "totalCost")
	private double totalCost;
	@Column(name = "days")
	private int days;

	public int getTourInfoId() {
		return tourInfoId;
	}

	public void setTourInfoId(int tourInfoId) {
		this.tourInfoId = tourInfoId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getTravelType() {
		return travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}