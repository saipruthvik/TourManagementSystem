package com.medplus.tourmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.HotelReservation;

@Repository
public interface HotelReservationDao extends JpaRepository<HotelReservation, Integer> {

	@Query(value = "select max(hotelReservationId) from HotelReservation")
	int getMaxHotelReservationId();

	@Query(value = "select hotelReservation from HotelReservation hotelReservation where hotelReservation.packageBookings.bookingId=?1")
	HotelReservation getHotelReservationByBookingId(int bookingId);
}
