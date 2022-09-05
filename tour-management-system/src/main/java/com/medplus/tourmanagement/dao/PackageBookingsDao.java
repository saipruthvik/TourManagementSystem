package com.medplus.tourmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.PackageBookings;

@Repository
public interface PackageBookingsDao extends JpaRepository<PackageBookings, Integer> {

	@Query(value = "select max(bookingId) from PackageBookings")
	int getMaxBookingId();

	@Query(value = "select packbkg from PackageBookings packbkg where packbkg.customerInfo.customerId = ?1")
	List<PackageBookings> getAllPackageBooking(int customerId);
}
