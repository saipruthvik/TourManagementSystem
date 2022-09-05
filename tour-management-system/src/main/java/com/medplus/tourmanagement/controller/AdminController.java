package com.medplus.tourmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplus.tourmanagement.dto.HotelDto;
import com.medplus.tourmanagement.dto.TourInformationDto;
import com.medplus.tourmanagement.entities.CustomerInfo;
import com.medplus.tourmanagement.entities.Hotel;
import com.medplus.tourmanagement.entities.TourInformation;
import com.medplus.tourmanagement.service.CustomerInfoService;
import com.medplus.tourmanagement.service.HotelService;
import com.medplus.tourmanagement.service.TourInformationService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	HotelService hotelService;

	@Autowired
	TourInformationService tourInformationService;

	@Autowired
	CustomerInfoService customerInfoService;

	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
	}

	@GetMapping("/hotelById/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") int hotelId) {
		return new ResponseEntity<>(hotelService.getHotelById(hotelId), HttpStatus.OK);
	}

	@PostMapping("/hotel")
	public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotelDto) {
		return new ResponseEntity<>(hotelService.addHotel(hotelDto), HttpStatus.OK);
	}

	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<String> deleteHotelById(@PathVariable("hotelId") int hotelId) {
		hotelService.deleteHotelById(hotelId);
		return new ResponseEntity<>("Hotel has been DELETED successfully !!!!", HttpStatus.OK);
	}

	@GetMapping("/hotel/{location}")
	public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable("location") String location) {
		return new ResponseEntity<>(hotelService.getHotelsByLocation(location), HttpStatus.OK);
	}

	@PutMapping("/hotel")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.OK);
	}

	@PostMapping("/tourInfo")
	public ResponseEntity<TourInformation> addTourInformation(@RequestBody TourInformationDto tourInformationDto) {

		return new ResponseEntity<>(tourInformationService.addTourInformation(tourInformationDto), HttpStatus.OK);
	}

	@GetMapping("/tourInfo")
	public ResponseEntity<List<TourInformation>> getAllTourInformations() {
		return new ResponseEntity<>(tourInformationService.getAllTourInformations(), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/{tourInfoId}")
	public ResponseEntity<TourInformation> getTourInformationById(@PathVariable("tourInfoId") int tourInfoId) {
		return new ResponseEntity<>(tourInformationService.getTourInformationById(tourInfoId), HttpStatus.OK);
	}

	@DeleteMapping("/tourInfo/{tourInfoId}")
	public ResponseEntity<String> deleteTourInformationsById(@PathVariable("tourInfoId") int tourInfoId) {
		tourInformationService.deleteTourInformationsById(tourInfoId);
		return new ResponseEntity<>("Tour Information is Deleted Successfully !!!!", HttpStatus.OK);
	}

	@PutMapping("/tourInfo")
	public ResponseEntity<TourInformation> updateTourInformation(@RequestBody TourInformation tourInformation) {
		return new ResponseEntity<>(tourInformationService.updateTourInformation(tourInformation), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/location/{location}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsByLocation(
			@PathVariable("location") String location) {
		return new ResponseEntity<>(tourInformationService.getAllTourInformationsByLocation(location), HttpStatus.OK);
	}

	@GetMapping("/customerInfo")
	public ResponseEntity<List<CustomerInfo>> getAllCustomerInfo() {
		return new ResponseEntity<>(customerInfoService.getAllCustomerInfo(), HttpStatus.OK);
	}
}
