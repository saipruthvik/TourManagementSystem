package com.medplus.tourmanagement.service;

import com.medplus.tourmanagement.dto.TicketReservationDto;

public interface TicketReservationService {

	TicketReservationDto addTicketReservation(int bookingId);

	TicketReservationDto cancelTicketReservation(int ticketReservationId);

	TicketReservationDto getTicketReservationStatus(int customerId);

	TicketReservationDto getTicketReservationStatuById(int ticketReservationId);

	TicketReservationDto getTicketReservationByBookingId(int bookingId);

}
