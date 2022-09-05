package com.medplus.tourmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TourmanagementExceptionsHandler {

	@ExceptionHandler(value = AddressDoesNotExistException.class)
	public ResponseEntity<String> exception(AddressDoesNotExistException ex) {
		return new ResponseEntity<>("Address does not Exist, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = AddressAlreadyExistException.class)
	public ResponseEntity<String> exception(AddressAlreadyExistException ex) {
		return new ResponseEntity<>("Address Already Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CustomerAddressAlreadyExistException.class)
	public ResponseEntity<String> exception(CustomerAddressAlreadyExistException ex) {
		return new ResponseEntity<>("Customer Address Already Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CustomerDependentDoesNotExistException.class)
	public ResponseEntity<String> exception(CustomerDependentDoesNotExistException ex) {
		return new ResponseEntity<>("Customer Dependent does Not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CustomerDoesNotExistException.class)
	public ResponseEntity<String> exception(CustomerDoesNotExistException ex) {
		return new ResponseEntity<>("Customer does Not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = EmptyCustomersListException.class)
	public ResponseEntity<String> exception(EmptyCustomersListException ex) {
		return new ResponseEntity<>("Customer list is Empty, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = HotelDoesNotExistException.class)
	public ResponseEntity<String> exception(HotelDoesNotExistException ex) {
		return new ResponseEntity<>("Hotel does Not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = EmptyHotelsListException.class)
	public ResponseEntity<String> exception(EmptyHotelsListException ex) {
		return new ResponseEntity<>("Empty List of Hotels, so do add some hotels and check again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = PackageBookingDoesNotExistException.class)
	public ResponseEntity<String> exception(PackageBookingDoesNotExistException ex) {
		return new ResponseEntity<>("Package Booking does not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PaymentAlreadyDoneException.class)
	public ResponseEntity<String> exception(PaymentAlreadyDoneException ex) {
		return new ResponseEntity<>("Payment has already completed, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PaymentNotCompletedException.class)
	public ResponseEntity<String> exception(PaymentNotCompletedException ex) {
		return new ResponseEntity<>("Payment not yet completed, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PackageReservationNotCompletedException.class)
	public ResponseEntity<String> exception(PackageReservationNotCompletedException ex) {
		return new ResponseEntity<>("Package Reservation is not done yet, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PackageCancelledException.class)
	public ResponseEntity<String> exception(PackageCancelledException ex) {
		return new ResponseEntity<>(
				"Package Reservation has been cancelled, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TourCompletedException.class)
	public ResponseEntity<String> exception(TourCompletedException ex) {
		return new ResponseEntity<>("Tour is Completed, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PackageAlreadyBookedException.class)
	public ResponseEntity<String> exception(PackageAlreadyBookedException ex) {
		return new ResponseEntity<>("Package Already Booked, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmptyPackageBookingsListException.class)
	public ResponseEntity<String> exception(EmptyPackageBookingsListException ex) {
		return new ResponseEntity<>("Package bookings list is Empty, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PackageNotBookedException.class)
	public ResponseEntity<String> exception(PackageNotBookedException ex) {
		return new ResponseEntity<>("Package not booked, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TicketReservationDoesNotExistException.class)
	public ResponseEntity<String> exception(TicketReservationDoesNotExistException ex) {
		return new ResponseEntity<>("Ticket Reservation does Not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = TicketReservationNotDoneException.class)
	public ResponseEntity<String> exception(TicketReservationNotDoneException ex) {
		return new ResponseEntity<>("Ticket Reservation not Done, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = TicketReservationAlreadyCompletedException.class)
	public ResponseEntity<String> exception(TicketReservationAlreadyCompletedException ex) {
		return new ResponseEntity<>("Ticket Reservation already completed, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = TourInformationDoesNotExistException.class)
	public ResponseEntity<String> exception(TourInformationDoesNotExistException ex) {
		return new ResponseEntity<>("Tour Information does Not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = EmptyTourInformationListException.class)
	public ResponseEntity<String> exception(EmptyTourInformationListException ex) {
		return new ResponseEntity<>("Tour Information list is Empty, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = LocationDoesNotExistException.class)
	public ResponseEntity<String> exception(LocationDoesNotExistException ex) {
		return new ResponseEntity<>("Location does Not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TravelTypeForGivenLocationDoesNotExistException.class)
	public ResponseEntity<String> exception(TravelTypeForGivenLocationDoesNotExistException ex) {
		return new ResponseEntity<>(
				"Travel type for given location does not Exist, so do check the details and try again !!!!",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserDoesNotExistException.class)
	public ResponseEntity<String> exception(UserDoesNotExistException ex) {
		return new ResponseEntity<>("User does not Exist, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = WrongUserPasswordException.class)
	public ResponseEntity<String> exception(WrongUserPasswordException ex) {
		return new ResponseEntity<>("Entered wrong password, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = UserRoleMisMatchException.class)
	public ResponseEntity<String> exception(UserRoleMisMatchException ex) {
		return new ResponseEntity<>("Entered wrong userRole, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = UserRoleDoesNotExistException.class)
	public ResponseEntity<String> exception(UserRoleDoesNotExistException ex) {
		return new ResponseEntity<>("UserRole does Not Exist, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = HotelReservationDoesNotExistException.class)
	public ResponseEntity<String> exception(HotelReservationDoesNotExistException ex) {
		return new ResponseEntity<>("Hotel Reservation does not Exist, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = TicketReservationAlreadyCancelledException.class)
	public ResponseEntity<String> exception(TicketReservationAlreadyCancelledException ex) {
		return new ResponseEntity<>("Ticket Reservation already cancelled, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = HotelReservationAlreadyCancelledException.class)
	public ResponseEntity<String> exception(HotelReservationAlreadyCancelledException ex) {
		return new ResponseEntity<>("Hotel Reservation already cancelled, so check the details and try again !!!!",
				HttpStatus.NOT_FOUND);

	}
}
