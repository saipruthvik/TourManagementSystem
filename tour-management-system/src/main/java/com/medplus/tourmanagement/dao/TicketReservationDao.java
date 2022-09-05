package com.medplus.tourmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.TicketReservation;

@Repository
public interface TicketReservationDao extends JpaRepository<TicketReservation, Integer> {

	@Query(value = "select max(ticketReservationId) from TicketReservation")
	int getMaxTicketReservationId();

	@Query(value = "select ticket from TicketReservation ticket where ticket.packageBookings.bookingId = ?1")
	TicketReservation getTicketReservationByBookingId(int bookingId);

}
