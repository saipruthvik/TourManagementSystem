package com.medplus.tourmanagement.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.tourmanagement.dao.HotelDao;
import com.medplus.tourmanagement.dao.HotelReservationDao;
import com.medplus.tourmanagement.dao.PackageBookingsDao;
import com.medplus.tourmanagement.dto.HotelReservationDto;
import com.medplus.tourmanagement.entities.Hotel;
import com.medplus.tourmanagement.entities.HotelReservation;
import com.medplus.tourmanagement.entities.PackageBookings;
import com.medplus.tourmanagement.exceptions.HotelDoesNotExistException;
import com.medplus.tourmanagement.exceptions.HotelReservationAlreadyCancelledException;
import com.medplus.tourmanagement.exceptions.HotelReservationDoesNotExistException;
import com.medplus.tourmanagement.exceptions.HotelReservationNotFoundException;
import com.medplus.tourmanagement.exceptions.PackageAlreadyBookedException;
import com.medplus.tourmanagement.exceptions.PackageBookingDoesNotExistException;
import com.medplus.tourmanagement.exceptions.PackageCancelledException;
import com.medplus.tourmanagement.exceptions.PaymentNotCompletedException;
import com.medplus.tourmanagement.exceptions.TourCompletedException;

@Service
public class HotelReservationServiceImpl implements HotelReservationService {

	@Autowired
	HotelReservationDao hotelReservationDao;

	@Autowired
	PackageBookingsDao packageBookingsDao;

	@Autowired
	HotelDao hotelDao;

	@Override
	public HotelReservation getHotelReservationByBookingId(int bookingId) {
		HotelReservation hotelReservation = hotelReservationDao.getHotelReservationByBookingId(bookingId);
		if (hotelReservation == null) {
			throw new HotelReservationNotFoundException();
		} else {
			return hotelReservation;
		}
	}

	@Override
	public HotelReservation addHotelReservation(HotelReservationDto hotelReservationDto) {
		List<HotelReservation> hotelReservationsList = hotelReservationDao.findAll();
		int hotelReservationId = 0;
		if (hotelReservationsList.isEmpty())
			hotelReservationId = 1000;
		else {
			hotelReservationId = hotelReservationDao.getMaxHotelReservationId();
			hotelReservationId++;
		}
		Optional<PackageBookings> packageBookings = packageBookingsDao.findById(hotelReservationDto.getBookingId());
		if (packageBookings.isEmpty())
			throw new PackageBookingDoesNotExistException();
		if (packageBookings.get().getBookingStatus().equals("Cancelled"))
			throw new PackageCancelledException();
		if (packageBookings.get().getBookingStatus().equals("Tour Completed"))
			throw new TourCompletedException();
		if (packageBookings.get().getBookingStatus().equals("Package Booked"))
			throw new PackageAlreadyBookedException();
		if (packageBookings.get().getBookingStatus().equals("Payment Completed and Processing")) {
			Optional<Hotel> hotel = hotelDao.findById(hotelReservationDto.getHotelId());
			if (hotel.isEmpty())
				throw new HotelDoesNotExistException();
			HotelReservation hotelReservation = new HotelReservation();
			hotelReservation.setHotelReservationId(hotelReservationId);
			hotelReservation.setPackageBookings(packageBookings.get());
			hotelReservation.setReservationStatus("Confirmed");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(packageBookings.get().getTripDate());
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			Date date = calendar.getTime();
			hotelReservation.setArrivingDate(date);
			calendar.add(Calendar.DAY_OF_MONTH, packageBookings.get().getTourInformation().getDays() - 2);
			date = calendar.getTime();
			hotelReservation.setExitDate(date);
			hotelReservation.setHotel(hotel.get());
			return hotelReservationDao.save(hotelReservation);
		} else
			throw new PaymentNotCompletedException();
	}

	@Override
	public HotelReservation cancelHotelReservation(int hotelReservationId) {
		Optional<HotelReservation> hotelReservation = hotelReservationDao.findById(hotelReservationId);
		if (hotelReservation.isEmpty())
			throw new HotelReservationDoesNotExistException();
		if (hotelReservation.get().getReservationStatus().equals("Confirmed")) {
			hotelReservation.get().setReservationStatus("Cancelled");
			return hotelReservationDao.save(hotelReservation.get());
		} else
			throw new HotelReservationAlreadyCancelledException();

	}

}
