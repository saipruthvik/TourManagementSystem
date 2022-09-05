package com.medplus.tourmanagement.dto;

public class TourInformationDto {

	private int tourInformationId;
	private String location;
	private String travelType;
	private String tourDescription;
	private double totalCost;
	private int days;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTravelType() {
		return travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getTourInformationId() {
		return tourInformationId;
	}

	public void setTourInformationId(int tourInformationId) {
		this.tourInformationId = tourInformationId;
	}

}
