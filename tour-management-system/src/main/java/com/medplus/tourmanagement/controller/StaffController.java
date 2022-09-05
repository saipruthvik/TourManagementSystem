package com.medplus.tourmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplus.tourmanagement.dto.HotelReservationDto;
import com.medplus.tourmanagement.dto.PackageBookingsDto;
import com.medplus.tourmanagement.dto.PackageBookingsForStaffDto;
import com.medplus.tourmanagement.dto.TicketReservationDto;
import com.medplus.tourmanagement.entities.Hotel;
import com.medplus.tourmanagement.entities.HotelReservation;
import com.medplus.tourmanagement.entities.TourInformation;
import com.medplus.tourmanagement.service.HotelReservationService;
import com.medplus.tourmanagement.service.HotelService;
import com.medplus.tourmanagement.service.PackageBookingsService;
import com.medplus.tourmanagement.service.TicketReservationService;
import com.medplus.tourmanagement.service.TourInformationService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	HotelService hotelService;
	@Autowired
	HotelReservationService hotelReservationService;

	@Autowired
	TicketReservationService ticketReservationService;

	@Autowired
	PackageBookingsService packageBookingsService;

	@Autowired
	TourInformationService tourInformationService;

//	@PostMapping("/hotelreservation")
//	public ResponseEntity<String> addHotelReservation(@RequestBody HotelReservationDto hotelReservationDto) {
//		HotelReservation hotelReservation = hotelReservationService.addHotelReservation(hotelReservationDto);
//		return new ResponseEntity<>("Hotel Reservation completed successfully and your reservation Id is "
//				+ hotelReservation.getHotelReservationId(), HttpStatus.OK);
//	}

//	@PutMapping("/hotelreservation/{hotelReservationId}")
//	public ResponseEntity<String> cancelHotelReservation(@PathVariable("hotelReservationId") int hotelReservationId) {
//		hotelReservationService.cancelHotelReservation(hotelReservationId);
//		return new ResponseEntity<>("Hotel Reservation has been Cancelled successfully !!!!", HttpStatus.OK);
//	}

//	@PostMapping("/ticketreservation/{bookingId}")
//	public ResponseEntity<String> addTicketReservation(@PathVariable("bookingId") int bookingId) {
//		TicketReservation ticketReservation = ticketReservationService.addTicketReservation(bookingId);
//		return new ResponseEntity<>("Ticket Reservation completed successfully and your reservation Id is "
//				+ ticketReservation.getTicketReservationId(), HttpStatus.OK);
//	}

//	@PutMapping("/ticketreservation/{ticketReservationId}")
//	public ResponseEntity<String> cancelTicketReservation(
//			@PathVariable("ticketReservationId") int ticketReservationId) {
//		ticketReservationService.cancelTicketReservation(ticketReservationId);
//		return new ResponseEntity<>("Hotel Reservation has been Cancelled successfully !!!!", HttpStatus.OK);
//	}

	@PutMapping("/packagebookings/{bookingId}/{status}")
	public ResponseEntity<String> updatePackageStatusAfterReceivingCash(@PathVariable("bookingId") int bookingId,
			@PathVariable("status") String status) {
		packageBookingsService.updatePackageStatus(bookingId, status);
		return new ResponseEntity<>("Your booking is under Processing !!!!", HttpStatus.OK);
	}

	@GetMapping("/packagebookings/{bookingId}")
	public ResponseEntity<PackageBookingsDto> getPackageBooking(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<>(packageBookingsService.getPackageBooking(bookingId), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/one/{bookingId}")
	public ResponseEntity<TourInformation> getAllTourInformationByBookingId(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<>(tourInformationService.getAllTourInformationByBookingId(bookingId), HttpStatus.OK);
	}

	@GetMapping("/packagebookings")
	public ResponseEntity<List<PackageBookingsForStaffDto>> getAllPackageBookings() {
		List<PackageBookingsForStaffDto> list = packageBookingsService.getAllPackageBookings();
		return new ResponseEntity<List<PackageBookingsForStaffDto>>(list, HttpStatus.OK);
	}

	@GetMapping("/packagebooking/{bookingId}")
	public ResponseEntity<PackageBookingsForStaffDto> getPackageBookingForStaff(
			@PathVariable("bookingId") int bookingId) {
		PackageBookingsForStaffDto packageBookingsForStaffDto = packageBookingsService
				.getPackageBookingForStaffById(bookingId);

		return new ResponseEntity<>(packageBookingsForStaffDto, HttpStatus.OK);
	}

	@PutMapping("/updatepackagebooking/{bookingId}")
	public ResponseEntity<PackageBookingsForStaffDto> updatePackageBookingForStaff(
			@PathVariable("bookingId") int bookingId) {
		PackageBookingsForStaffDto packageBookingsForStaffDto = packageBookingsService
				.updatePackageBookingForStaffById(bookingId);

		return new ResponseEntity<>(packageBookingsForStaffDto, HttpStatus.OK);
	}

	@GetMapping("/gethotels/{location}/{totalCost}")
	public ResponseEntity<List<Hotel>> getHotelsForStaff(@PathVariable("location") String location,
			@PathVariable("totalCost") double totalCost) {
		List<Hotel> hotels = hotelService.getHotelsByLocationAndCost(location, totalCost);

		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

	@GetMapping("/gethotelreservation/{bookingId}")
	public ResponseEntity<HotelReservation> getHotelReservationById(@PathVariable("bookingId") int bookingId) {
		HotelReservation hotelReservation = hotelReservationService.getHotelReservationByBookingId(bookingId);

		return new ResponseEntity<>(hotelReservation, HttpStatus.OK);
	}

	@GetMapping("/getticketreservation/{bookingId}")
	public ResponseEntity<TicketReservationDto> getTicketReservationById(@PathVariable("bookingId") int bookingId) {
		TicketReservationDto ticketReservationDto = ticketReservationService.getTicketReservationByBookingId(bookingId);

		return new ResponseEntity<>(ticketReservationDto, HttpStatus.OK);
	}

	@PostMapping("/hotelreservation")
	public ResponseEntity<HotelReservation> addHotelReservation(@RequestBody HotelReservationDto hotelReservationDto) {
		HotelReservation hotelReservation = hotelReservationService.addHotelReservation(hotelReservationDto);
		return new ResponseEntity<>(hotelReservation, HttpStatus.OK);
	}

	@PostMapping("/ticketreservation/{bookingId}")
	public ResponseEntity<TicketReservationDto> addTicketReservation(@PathVariable("bookingId") int bookingId) {
		TicketReservationDto ticketReservationDto = ticketReservationService.addTicketReservation(bookingId);
		return new ResponseEntity<>(ticketReservationDto, HttpStatus.OK);
	}

	@PutMapping("/cancelhotelreservation/{hotelReservationId}")
	public ResponseEntity<HotelReservation> cancelHotelReservation(
			@PathVariable("hotelReservationId") int hotelReservationId) {
		HotelReservation hotelReservation = hotelReservationService.cancelHotelReservation(hotelReservationId);
		return new ResponseEntity<>(hotelReservation, HttpStatus.OK);
	}

	@PutMapping("/cancelticketreservation/{ticketReservationId}")
	public ResponseEntity<TicketReservationDto> cancelTicketReservation(
			@PathVariable("ticketReservationId") int ticketReservationId) {
		TicketReservationDto ticketReservationDto = ticketReservationService
				.cancelTicketReservation(ticketReservationId);
		return new ResponseEntity<>(ticketReservationDto, HttpStatus.OK);
	}
}
