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

import com.medplus.tourmanagement.dto.AddressDto;
import com.medplus.tourmanagement.dto.CustInfoAddressDTO;
import com.medplus.tourmanagement.dto.CustomerDependentDto;
import com.medplus.tourmanagement.dto.CustomerInfoDto;
import com.medplus.tourmanagement.dto.PackageBookingsDto;
import com.medplus.tourmanagement.dto.TicketReservationDto;
import com.medplus.tourmanagement.dto.TourInformationDto;
import com.medplus.tourmanagement.entities.Address;
import com.medplus.tourmanagement.entities.CustomerInfo;
import com.medplus.tourmanagement.entities.PackageBookings;
import com.medplus.tourmanagement.entities.TourInformation;
import com.medplus.tourmanagement.entities.UserLogin;
import com.medplus.tourmanagement.service.AddressService;
import com.medplus.tourmanagement.service.CustomerInfoService;
import com.medplus.tourmanagement.service.PackageBookingsService;
import com.medplus.tourmanagement.service.TicketReservationService;
import com.medplus.tourmanagement.service.TourInformationService;
import com.medplus.tourmanagement.service.UserLoginService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	AddressService addressService;

	@Autowired
	CustomerInfoService customerInfoService;

	@Autowired
	PackageBookingsService packageBookingsService;

	@Autowired
	TicketReservationService ticketReservationService;

	@Autowired
	TourInformationService tourInformationService;

	@Autowired
	UserLoginService userLoginService;

	@PostMapping("/cust")
	public ResponseEntity<String> addCustomer(@RequestBody CustInfoAddressDTO cust) {
		CustomerInfoDto custDto = new CustomerInfoDto();
		custDto.setCustomerName(cust.getCustomerName());
		custDto.setCustomerAge(cust.getCustomerAge());
		custDto.setPhoneNo(cust.getPhoneNo());
		CustomerInfo customerInfo = customerInfoService.addCustomerInfo(custDto);
		Address address = new Address();
		address.setCustomerInfo(customerInfo);
		address.setHouseNo(cust.getHouseNo());
		address.setCity(cust.getCity());
		address.setPincode(cust.getPincode());
		address.setState(cust.getState());
		address.setStreet(cust.getStreet());
		address = addressService.addAddress(address);
		UserLogin userLogin = customerInfo.getUserLogin();
		return new ResponseEntity<>("Your customer Id is " + customerInfo.getCustomerId() + "	Your User is = "
				+ userLogin.getUserId() + " Password is = " + userLogin.getPassword(), HttpStatus.OK);
	}

	@GetMapping("/address/{customerId}")
	public ResponseEntity<Address> getAddressByCustomerId(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<>(addressService.getAddressByCustomerId(customerId), HttpStatus.OK);
	}

	@PostMapping("/address")
	public ResponseEntity<String> addAddress(@RequestBody Address address) {
		addressService.addAddress(address);
		return new ResponseEntity<>("Address is ADDED successfully !!!!", HttpStatus.OK);
	}

	@PutMapping("/address")
	public ResponseEntity<String> updateAddress(@RequestBody AddressDto addressDto) {
		addressService.updateAddress(addressDto);
		return new ResponseEntity<>("Address is Updated Successfully !!!!", HttpStatus.OK);
	}

	@DeleteMapping("/address/{customerId}")
	public ResponseEntity<String> deleteAddress(@PathVariable("customerId") int customerId) {
		addressService.deleteAddress(customerId);
		return new ResponseEntity<>("Address is DELETED successfully !!!!", HttpStatus.OK);
	}

	@PutMapping("/custinfo/name/{customerId}/{customerName}")
	public ResponseEntity<String> updateNameWithCustomerId(@PathVariable("customerId") int customerId,
			@PathVariable("customerName") String customerName) {
		customerInfoService.updateNameWithCustomerId(customerId, customerName);
		return new ResponseEntity<>(
				"Customer Information is Updated Successfully ... Bro and the updated Name is " + customerName,
				HttpStatus.OK);
	}

	@PutMapping("/custinfo/phoneNo/{customerId}/{phoneNo}")
	public ResponseEntity<String> updatePhoneNoWithCustomerId(@PathVariable("customerId") int customerId,
			@PathVariable("phoneNo") long phoneNo) {
		customerInfoService.updatePhoneNoWithCustomerId(customerId, phoneNo);
		return new ResponseEntity<>(
				"Customer Information is Updated Successfully ... Bro and the updated Phone No is " + phoneNo,
				HttpStatus.OK);
	}

	@PutMapping("/custinfo/age/{customerId}/{customerAge}")
	public ResponseEntity<String> updateAgeWithCustomerId(@PathVariable("customerId") int customerId,
			@PathVariable("customerAge") int customerAge) {
		customerInfoService.updateAgeWithCustomerId(customerId, customerAge);
		return new ResponseEntity<>(
				"Customer Information is Updated Successfully ... Bro and the updated age is " + customerAge,
				HttpStatus.OK);
	}

	@PutMapping("/custinfo/{customerId}")
	public ResponseEntity<String> updateCustomerInfo(@PathVariable("customerId") int customerId,
			@RequestBody CustomerInfoDto customerInfoDto) {
		customerInfoService.updateCustomerInfo(customerId, customerInfoDto);
		return new ResponseEntity<>("Customer Information is updated Successfully !!!!!", HttpStatus.OK);
	}

	@GetMapping("/custinfo/{customerId}")
	public ResponseEntity<CustomerInfo> getCustomerInfoByCustomerId(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<>(customerInfoService.getCustomerInfoByCustomerId(customerId), HttpStatus.OK);
	}

	@GetMapping("/custinfo/user/{userId}")
	public ResponseEntity<CustomerInfo> getCustomerInfoByUserId(@PathVariable int userId) {
		return new ResponseEntity<>(customerInfoService.getCustomerInfoByUserId(userId), HttpStatus.OK);
	}

	@PostMapping("/packagebookings")
	public ResponseEntity<String> addPackageBookings(@RequestBody PackageBookingsDto packageBookingsDto) {
		PackageBookings packageBookings = packageBookingsService.addPackageBookings(packageBookingsDto);
		return new ResponseEntity<>(
				"Package Booking is completed and your booking id is " + packageBookings.getBookingId(), HttpStatus.OK);
	}

	@PutMapping("/packagebookings/{bookingId}")
	public ResponseEntity<String> cancelPackageBooking(@PathVariable("bookingId") int bookingId) {
		packageBookingsService.cancelPackageBooking(bookingId);
		return new ResponseEntity<>("Your booking is Cancelled Successfully !!!!", HttpStatus.OK);
	}

	@GetMapping("/packagebookings/one/{bookingId}")
	public ResponseEntity<PackageBookingsDto> getPackageBooking(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<>(packageBookingsService.getPackageBooking(bookingId), HttpStatus.OK);
	}

	@GetMapping("/packagebookings/all/{customerId}")
	public ResponseEntity<List<PackageBookings>> getAllPackageBooking(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<>(packageBookingsService.getAllPackageBooking(customerId), HttpStatus.OK);
	}

	@GetMapping("/ticket/{customerId}")
	public ResponseEntity<TicketReservationDto> getTicketReservationByCustomerId(
			@PathVariable("customerId") int customerId) {
		return new ResponseEntity<>(ticketReservationService.getTicketReservationStatus(customerId), HttpStatus.OK);
	}

	@GetMapping("/ticket/reservationId/{ticketReservationId}")
	public ResponseEntity<TicketReservationDto> getTicketReservationStatuById(
			@PathVariable("ticketReservationId") int ticketReservationId) {
		return new ResponseEntity<>(ticketReservationService.getTicketReservationStatuById(ticketReservationId),
				HttpStatus.OK);
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

	@GetMapping("/tourInfo")
	public ResponseEntity<List<TourInformation>> getAllTourInformations() {
		return new ResponseEntity<>(tourInformationService.getAllTourInformations(), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/{location}/{typeOfTravel}/{startDate}/{endDate}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsWithInSpan(
			@PathVariable("location") String location, @PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		return new ResponseEntity<>(
				tourInformationService.getAllTourInformationsWithInSpan(location, startDate, endDate), HttpStatus.OK);
	}

	@GetMapping("/tourInfo/cost/{cost}")
	public ResponseEntity<List<TourInformationDto>> getAllTourInformationsByCost(@PathVariable("cost") double cost) {
		return new ResponseEntity<>(tourInformationService.getAllTourInformationsByCost(cost), HttpStatus.OK);
	}

	@PutMapping("/{userId}/{password}")
	public ResponseEntity<String> updateUserPassword(@PathVariable("userId") int userId,
			@PathVariable("password") String password) {
		userLoginService.updateUserPassword(userId, password);
		return new ResponseEntity<>("Password Updated Successfully !!! and new Password is " + password, HttpStatus.OK);
	}
}
