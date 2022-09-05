package com.medplus.tourmanagement.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.tourmanagement.dto.PackageBookingsDto;
import com.medplus.tourmanagement.exceptions.PackageBookingDoesNotExistException;
import com.medplus.tourmanagement.service.PackageBookingsService;
import com.medplus.tourmanagement.utils.DateParsing;

@SpringBootTest
public class PackageBookingsServiceTest {
	@Autowired
	PackageBookingsService packageBookingsService;

	@Test
	void testAddPackageBookingsTrue() {
		PackageBookingsDto packageBookingsDto = new PackageBookingsDto();
		packageBookingsDto.setCustomerId(110002);
		packageBookingsDto.setTourInfoId(1112);
		packageBookingsDto.setTypeOfPayment("Online Debit Card");
		Date date = DateParsing.getDate("2022-12-09");
		packageBookingsDto.setTripDate(date);
		assertTrue(packageBookingsService.addPackageBookings(packageBookingsDto) != null);
	}

	@Test
	void testCancelPackageBookingThrows() {
		assertThrows(PackageBookingDoesNotExistException.class,
				() -> packageBookingsService.cancelPackageBooking(19209));

	}

	@Test
	void testUpdatePackageStatusNotNull() {
		assertNotNull(packageBookingsService.updatePackageStatus(5502, "Tour Completed"));
	}

	@Test
	void testGetPackageBookingBookingIdNotNull() {
		assertNotNull(packageBookingsService.getPackageBooking(5500));
	}

	@Test
	void testGetAllPackageBookingByCustomerIdNotNull() {
		assertNotNull(packageBookingsService.getAllPackageBooking(110002));
	}

}