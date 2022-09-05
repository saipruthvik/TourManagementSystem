package com.medplus.tourmanagement.dto;

import java.util.Date;

public class TicketReservationDto {

	private int ticketReservationId;
	private String reservationStatus;
	private Date arrivalDate;
	private Date depatureDate;

	public int getTicketReservationId() {
		return ticketReservationId;
	}

	public void setTicketReservationId(int ticketReservationId) {
		this.ticketReservationId = ticketReservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

}
