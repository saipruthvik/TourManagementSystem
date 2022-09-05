package com.medplus.tourmanagement.dto;

import java.util.Date;

public class PackageBookingsDto {

	private int tourInfoId;
	private int customerId;
	private String typeOfPayment;
	private Date tripDate;
	private int packageCost;

	public int getTourInfoId() {
		return tourInfoId;
	}

	public void setTourInfoId(int tourInfoId) {
		this.tourInfoId = tourInfoId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTypeOfPayment() {
		return typeOfPayment;
	}

	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public int getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}

}
