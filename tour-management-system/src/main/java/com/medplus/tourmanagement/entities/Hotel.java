package com.medplus.tourmanagement.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	private int hotelId;
	@Column(name = "hotelName", length = 30)
	private String hotelName;
	// hotel Description : Address,city,state,pincode,contact no
	@Column(name = "hotelDescription", length = 100)
	private String hotelDescription;
	@Column(name = "location", length = 30)
	private String location;
	@Column
	@ElementCollection
	private List<String> roomType;
	@Column(name = "hotelServiceCost")
	private double hotelServiceCost;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

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

	public List<String> getRoomType() {
		return roomType;
	}

	public void setRoomType(List<String> roomType) {
		this.roomType = roomType;
	}

	public double getHotelServiceCost() {
		return hotelServiceCost;
	}

	public void setHotelServiceCost(double hotelServiceCost) {
		this.hotelServiceCost = hotelServiceCost;
	}

}
