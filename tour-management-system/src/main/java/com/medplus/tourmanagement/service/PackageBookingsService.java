package com.medplus.tourmanagement.service;

import java.util.List;

import com.medplus.tourmanagement.dto.PackageBookingsDto;
import com.medplus.tourmanagement.dto.PackageBookingsForStaffDto;
import com.medplus.tourmanagement.entities.PackageBookings;

public interface PackageBookingsService {

	PackageBookings addPackageBookings(PackageBookingsDto packageBookingsDto);

	PackageBookings cancelPackageBooking(int bookingId);

	PackageBookings updatePackageStatus(int bookingId, String status);

	PackageBookingsDto getPackageBooking(int bookingId);

	List<PackageBookings> getAllPackageBooking(int customerId);

	List<PackageBookingsForStaffDto> getAllPackageBookings();

	PackageBookingsForStaffDto getPackageBookingForStaffById(int bookingId);

	PackageBookingsForStaffDto updatePackageBookingForStaffById(int bookingId);

}
