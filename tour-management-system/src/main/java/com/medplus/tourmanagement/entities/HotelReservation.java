package com.medplus.tourmanagement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotelReservation")
public class HotelReservation {

	@Id
	private int hotelReservationId;
	@OneToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotel;
	@OneToOne
	@JoinColumn(name = "bookingId")
	private PackageBookings packageBookings;
	@Column(name = "reservationStatus")
	private String reservationStatus;
	@Column(name = "arrivingDate")
	private Date arrivingDate;
	@Column(name = "exitDate")
	private Date exitDate;

	public int getHotelReservationId() {
		return hotelReservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public void setHotelReservationId(int hotelReservationId) {
		this.hotelReservationId = hotelReservationId;
	}

	public PackageBookings getPackageBookings() {
		return packageBookings;
	}

	public void setPackageBookings(PackageBookings packageBookings) {
		this.packageBookings = packageBookings;
	}

	public Date getArrivingDate() {
		return arrivingDate;
	}

	public void setArrivingDate(Date arrivingDate) {
		this.arrivingDate = arrivingDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
