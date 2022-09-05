package com.medplus.tourmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.tourmanagement.dao.HotelDao;
import com.medplus.tourmanagement.dao.PackageBookingsDao;
import com.medplus.tourmanagement.dao.TourInformationDao;
import com.medplus.tourmanagement.dto.TourInformationDto;
import com.medplus.tourmanagement.entities.PackageBookings;
import com.medplus.tourmanagement.entities.TourInformation;
import com.medplus.tourmanagement.exceptions.EmptyTourInformationListException;
import com.medplus.tourmanagement.exceptions.LocationDoesNotExistException;
import com.medplus.tourmanagement.exceptions.PackageBookingDoesNotExistException;
import com.medplus.tourmanagement.exceptions.TourInformationDoesNotExistException;
import com.medplus.tourmanagement.exceptions.TravelTypeForGivenLocationDoesNotExistException;
import com.medplus.tourmanagement.utils.DateParsing;

@Service
public class TourInformationServiceImpl implements TourInformationService {

	@Autowired
	TourInformationDao tourInformationDao;

	@Autowired
	HotelDao hotelDao;

	@Autowired
	PackageBookingsDao packageBookingsDao;

	@Override
	public TourInformation addTourInformation(TourInformationDto tourInformationDto) {
		List<TourInformation> tourInformationsList = tourInformationDao.findAll();
		int tourInfoId = 0;
		if (tourInformationsList.isEmpty())
			tourInfoId = 1110;
		else
			tourInfoId = tourInformationDao.getMaxTourInformationId();
		tourInfoId++;
		TourInformation tourInformation = new TourInformation();
		tourInformation.setTourInfoId(tourInfoId);
		tourInformation.setLocation(tourInformationDto.getLocation());
		tourInformation.setTourDescription(tourInformationDto.getTourDescription());
		tourInformation.setTotalCost(tourInformationDto.getTotalCost());
		tourInformation.setTravelType(tourInformationDto.getTravelType());
		tourInformation.setDays(tourInformationDto.getDays());
		return tourInformationDao.save(tourInformation);
	}

	@Override
	public List<TourInformation> getAllTourInformations() {
		if (tourInformationDao.findAll().isEmpty())
			throw new EmptyTourInformationListException();
		return tourInformationDao.findAll();
	}

	@Override
	public void deleteTourInformationsById(int tourInfoId) {
		Optional<TourInformation> tourInformation = tourInformationDao.findById(tourInfoId);
		if (tourInformation.isEmpty())
			throw new TourInformationDoesNotExistException();
		tourInformationDao.deleteById(tourInfoId);
	}

	@Override
	public TourInformation getTourInformationById(int tourInfoId) {
		Optional<TourInformation> tourInformation = tourInformationDao.findById(tourInfoId);
		if (tourInformation == null)
			throw new TourInformationDoesNotExistException();
		return tourInformation.get();
	}

	@Override
	public TourInformation updateTourInformation(TourInformation tourInformation) {
		Optional<TourInformation> tourInfo = tourInformationDao.findById(tourInformation.getTourInfoId());
		if (tourInfo == null) {
			throw new TourInformationDoesNotExistException();
		}
		return tourInformationDao.save(tourInformation);
	}

//	@Override
//	public TourInformation addTourInformation(TourInformationDto tourInformationDto) {
//		List<TourInformation> tourInformationsList = tourInformationDao.findAll();
//		int tourInfoId = 0;
//		if (tourInformationsList.isEmpty())
//			tourInfoId = 1110;
//		else
//			tourInfoId = tourInformationDao.getMaxTourInformationId();
//		tourInfoId++;
//		TourInformation tourInformation = new TourInformation();
//		tourInformation.setTourInfoId(tourInfoId);
//		tourInformation.setLocation(tourInformationDto.getLocation());
//		tourInformation.setTourDescription(tourInformationDto.getTourDescription());
//		tourInformation.setTotalCost(tourInformationDto.getTotalCost());
//		tourInformation.setTravelType(tourInformationDto.getTravelType());
//		tourInformation.setDays(tourInformationDto.getDays());
//		return tourInformationDao.save(tourInformation);
//	}
//
//	@Override
//	public List<TourInformation> getAllTourInformations() {
//		return tourInformationDao.findAll();
//	}
//
//	@Override
//	public TourInformation getTourInformationById(int tourInfoId) {
//		return null;
//	}

//	@Override
//	public TourInformation updateTourInformation(TourInformation tourInformation) {
//		return null;
//	}

	@Override
	public List<TourInformationDto> getAllTourInformationsByLocation(String location) {
		List<TourInformation> tourInformationList = tourInformationDao.getAllTourInformationsByLocation(location);
		if (tourInformationList.isEmpty())
			throw new LocationDoesNotExistException();
		List<TourInformationDto> tourInformationDtosList = new ArrayList<>();
		for (TourInformation tInformation : tourInformationList) {
			TourInformationDto tourInformationDto = new TourInformationDto();
			tourInformationDto.setLocation(tInformation.getLocation());
			tourInformationDto.setTourDescription(tInformation.getTourDescription());
			tourInformationDto.setTotalCost(tInformation.getTotalCost());
			tourInformationDto.setTravelType(tInformation.getTravelType());
			tourInformationDto.setDays(tInformation.getDays());
			tourInformationDtosList.add(tourInformationDto);
		}
		return tourInformationDtosList;
	}

//	@Override
//	public void deleteTourInformationsById(int tourInfoId) {
//		Optional<TourInformation> tourInformation = tourInformationDao.findById(tourInfoId);
//		if (tourInformation.isEmpty())
//			throw new TourInformationDoesNotExistException();
//		tourInformationDao.deleteById(tourInfoId);
//	}

//	@Override
//	public TourInformation updateTourInformationById(int tourInfoId, String description, double totaCost, int days) {
//
//		Optional<TourInformation> tourInformation = tourInformationDao.findById(tourInfoId);
//		if (tourInformation.isEmpty())
//			throw new TourInformationDoesNotExistException();
//		tourInformation.get().setTotalCost(totaCost);
//		tourInformation.get().setTourDescription(description);
//		tourInformation.get().setTotalCost(totaCost);
//		tourInformation.get().setDays(days);
//		return tourInformationDao.save(tourInformation.get());
//	}

	@Override
	public List<TourInformationDto> getAllTourInformationsByTypeofTravel(String location, String typeOfTravel) {
		List<TourInformation> tourInformation = tourInformationDao.getAllTourInformationsByLocation(location);
		if (tourInformation.isEmpty())
			throw new LocationDoesNotExistException();
		List<TourInformation> tourInformationList = tourInformationDao.getAllTourInformationsByTypeofTravel(location,
				typeOfTravel);
		if (tourInformationList.isEmpty())
			throw new TravelTypeForGivenLocationDoesNotExistException();
		List<TourInformationDto> tourInformationDtosList = new ArrayList<>();
		for (TourInformation tInformation : tourInformationList) {
			TourInformationDto tourInformationDto = new TourInformationDto();
			tourInformationDto.setLocation(tInformation.getLocation());
			tourInformationDto.setTourDescription(tInformation.getTourDescription());
			tourInformationDto.setTotalCost(tInformation.getTotalCost());
			tourInformationDto.setTravelType(tInformation.getTravelType());
			tourInformationDto.setDays(tInformation.getDays());
			tourInformationDtosList.add(tourInformationDto);
		}
		return tourInformationDtosList;
	}

	@Override
	public List<TourInformationDto> getAllTourInformationsWithInSpan(String location, String startDate,
			String endDate) {
		List<TourInformation> tourInformation = tourInformationDao.getAllTourInformationsByLocation(location);
		if (tourInformation.isEmpty())
			throw new LocationDoesNotExistException();
		long diff = DateParsing.getDate(endDate).getTime() - DateParsing.getDate(startDate).getTime();
		int days = (int) diff;
		List<TourInformation> tourInformationList = tourInformationDao.getAllTourInformationsWithInSpan(location, days);
		if (tourInformationList.isEmpty())
			throw new TravelTypeForGivenLocationDoesNotExistException();
		List<TourInformationDto> tourInformationDtosList = new ArrayList<>();
		for (TourInformation tInformation : tourInformationList) {
			TourInformationDto tourInformationDto = new TourInformationDto();
			tourInformationDto.setLocation(tInformation.getLocation());
			tourInformationDto.setTourDescription(tInformation.getTourDescription());
			tourInformationDto.setTotalCost(tInformation.getTotalCost());
			tourInformationDto.setTravelType(tInformation.getTravelType());
			tourInformationDto.setDays(tInformation.getDays());
			tourInformationDtosList.add(tourInformationDto);
		}
		return tourInformationDtosList;
	}

	@Override
	public TourInformation getAllTourInformationByBookingId(int bookingId) {
		Optional<PackageBookings> packageBookings = packageBookingsDao.findById(bookingId);
		if (packageBookings.isEmpty())
			throw new PackageBookingDoesNotExistException();
		Optional<TourInformation> tourInformation = tourInformationDao
				.findById(packageBookings.get().getTourInformation().getTourInfoId());
		return tourInformation.get();
	}

	@Override
	public List<TourInformationDto> getAllTourInformationsByCost(double cost) {
		List<TourInformation> tourInformationList = tourInformationDao.getAllTourInformationsByCost(cost);
		if (tourInformationList.isEmpty())
			throw new LocationDoesNotExistException();
		List<TourInformationDto> tourInformationDtosList = new ArrayList<>();
		for (TourInformation tInformation : tourInformationList) {
			TourInformationDto tourInformationDto = new TourInformationDto();
			tourInformationDto.setLocation(tInformation.getLocation());
			tourInformationDto.setTourDescription(tInformation.getTourDescription());
			tourInformationDto.setTotalCost(tInformation.getTotalCost());
			tourInformationDto.setTravelType(tInformation.getTravelType());
			tourInformationDto.setDays(tInformation.getDays());
			tourInformationDtosList.add(tourInformationDto);
		}
		return tourInformationDtosList;
	}

	@Override
	public TourInformation getTourInformationByTourId(int tourId) {
		Optional<TourInformation> tourInfo = tourInformationDao.findById(tourId);
		if (tourInfo.isPresent()) {
			return tourInfo.get();
		}
		throw new TourInformationDoesNotExistException();
	}

}
