package com.medplus.tourmanagement.service;

import com.medplus.tourmanagement.dto.HotelReservationDto;
import com.medplus.tourmanagement.entities.HotelReservation;

public interface HotelReservationService {

	HotelReservation addHotelReservation(HotelReservationDto hotelReservationDto);

	HotelReservation cancelHotelReservation(int hotelReservationId);

	HotelReservation getHotelReservationByBookingId(int bookingId);
}
