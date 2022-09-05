package com.medplus.tourmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplus.tourmanagement.dto.CustomerInfoDto;
import com.medplus.tourmanagement.dto.PackageBookingsDto;
import com.medplus.tourmanagement.dto.TourInformationDto;
import com.medplus.tourmanagement.entities.CustomerInfo;
import com.medplus.tourmanagement.entities.PackageBookings;
import com.medplus.tourmanagement.entities.TourInformation;
import com.medplus.tourmanagement.entities.UserLogin;
import com.medplus.tourmanagement.service.AddressService;
import com.medplus.tourmanagement.service.CustomerInfoService;
import com.medplus.tourmanagement.service.PackageBookingsService;
import com.medplus.tourmanagement.service.TourInformationService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/newuser")
public class NewUserController {

	@Autowired
	CustomerInfoService customerInfoService;

	@Autowired
	PackageBookingsService packageBookingsService;

	@Autowired
	TourInformationService tourInformationService;

	@Autowired
	AddressService addressService;

//	@PostMapping("/cust")
//	public ResponseEntity<String> addCustomer(@RequestBody CustInfoAddressDTO cust) {
//		CustomerInfoDto custDto = new CustomerInfoDto();
//		custDto.setCustomerName(cust.getCustomerName());
//		custDto.setCustomerAge(cust.getCustomerAge());
//		custDto.setPhoneNo(cust.getPhoneNo());
//		CustomerInfo customerInfo = customerInfoService.addCustomerInfo(custDto);
//		Address address = new Address();
//		address.setCustomerInfo(customerInfo);
//		address.setHouseNo(cust.getHouseNo());
//		address.setCity(cust.getCity());
//		address.setPincode(cust.getPincode());
//		address.setState(cust.getState());
//		address.setStreet(cust.getStreet());
//		address = addressService.addAddress(address);
//		UserLogin userLogin = customerInfo.getUserLogin();
//		return new ResponseEntity<String>("Your customer Id is " + customerInfo.getCustomerId() + "	Your User is = "
//				+ userLogin.getUserId() + " Password is = " + userLogin.getPassword(), HttpStatus.OK);
//	}

	@PostMapping("/custinfo")
	public ResponseEntity<String> addCustomerInfo(@RequestBody CustomerInfoDto customerInfoDto) {
		CustomerInfo customerInfo = customerInfoService.addCustomerInfo(customerInfoDto);
		UserLogin userLogin = customerInfo.getUserLogin();
		return new ResponseEntity<>("Your customer Id is " + customerInfo.getCustomerId() + "	Your User is = "
				+ userLogin.getUserId() + " Password is = " + userLogin.getPassword(), HttpStatus.OK);
	}

	@PostMapping("/packagebookings")
	public ResponseEntity<String> addPackageBookings(@RequestBody PackageBookingsDto packageBookingsDto) {
		PackageBookings packageBookings = packageBookingsService.addPackageBookings(packageBookingsDto);
		return new ResponseEntity<>(
				"Package Booking is completed and your booking id is " + packageBookings.getBookingId(), HttpStatus.OK);
	}

	@GetMapping("/tourInfo")
	public ResponseEntity<List<TourInformation>> getAllTourInformations() {
		return new ResponseEntity<>(tourInformationService.getAllTourInformations(), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/{location}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsByLocation(
			@PathVariable("location") String location) {
		return new ResponseEntity<>(tourInformationService.getAllTourInformationsByLocation(location), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/{location}/{typeOfTravel}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsByTypeofTravel(
			@PathVariable("location") String location, @PathVariable("typeOfTravel") String typeOfTravel) {
		return new ResponseEntity<>(tourInformationService.getAllTourInformationsByTypeofTravel(location, typeOfTravel),
				HttpStatus.OK);
	}

	@GetMapping("/tourInfo/{location}/{typeOfTravel}/{startDate}/{endDate}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsWithInSpan(
			@PathVariable("location") String location, @PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		return new ResponseEntity<>(
				tourInformationService.getAllTourInformationsWithInSpan(location, startDate, endDate), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/cost/{cost}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsWithInSpan(
			@PathVariable("cost") double cost) {
		return new ResponseEntity<>(tourInformationService.getAllTourInformationsByCost(cost), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/tourId/{tourId}")
	public ResponseEntity<TourInformation> getTourInformationByTourId(@PathVariable int tourId) {
		return new ResponseEntity<>(tourInformationService.getTourInformationByTourId(tourId), HttpStatus.OK);
	}
}
