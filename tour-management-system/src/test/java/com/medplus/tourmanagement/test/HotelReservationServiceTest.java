package com.medplus.tourmanagement.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.tourmanagement.dto.HotelReservationDto;
import com.medplus.tourmanagement.exceptions.HotelReservationAlreadyCancelledException;
import com.medplus.tourmanagement.exceptions.PackageBookingDoesNotExistException;
import com.medplus.tourmanagement.service.HotelReservationService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class HotelReservationServiceTest {

	@Autowired
	HotelReservationService hotelReservationService;

	@Test
	@Order(1)
	public void testAddHotelReservationThrows() {
		HotelReservationDto hotelReservationDto = new HotelReservationDto();
		hotelReservationDto.setHotelId(1000);
		hotelReservationDto.setBookingId(1000);
		assertThrows(PackageBookingDoesNotExistException.class,
				() -> hotelReservationService.addHotelReservation(hotelReservationDto));
	}

	@Test
	@Order(2)
	public void testCancelHotelReservationThrows() {
		assertThrows(HotelReservationAlreadyCancelledException.class,
				() -> hotelReservationService.cancelHotelReservation(1000));
	}
}