package com.medplus.tourmanagement.dto;

import java.util.List;

public class HotelDto {

	private String hotelName;
	private String hotelDescription;
	private String location;
	private double hotelServiceCost;
	private List<String> roomType;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getHotelServiceCost() {
		return hotelServiceCost;
	}

	public void setHotelServiceCost(double hotelServiceCost) {
		this.hotelServiceCost = hotelServiceCost;
	}

	public List<String> getRoomType() {
		return roomType;
	}

	public void setRoomType(List<String> roomType) {
		this.roomType = roomType;
	}

}
