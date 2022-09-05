package com.medplus.tourmanagement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticketReservation")
public class TicketReservation {

	@Id
	private int ticketReservationId;
	@OneToOne
	@JoinColumn(name = "bookingId")
	private PackageBookings packageBookings;
	@Column(name = "reservationStatus")
	private String reservationStatus;
	@Column(name = "arrivingDate")
	private Date arrivingDate;
	@Column(name = "depatureDate")
	private Date depatureDate;

	public int getTicketReservationId() {
		return ticketReservationId;
	}

	public void setTicketReservationId(int ticketReservationId) {
		this.ticketReservationId = ticketReservationId;
	}

	public PackageBookings getPackageBookings() {
		return packageBookings;
	}

	public void setPackageBookings(PackageBookings packageBookings) {
		this.packageBookings = packageBookings;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Date getArrivingDate() {
		return arrivingDate;
	}

	public void setArrivingDate(Date arrivingDate) {
		this.arrivingDate = arrivingDate;
	}

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

}
