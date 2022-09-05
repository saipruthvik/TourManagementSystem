package com.medplus.tourmanagement.service;

import java.util.List;

import com.medplus.tourmanagement.dto.TourInformationDto;
import com.medplus.tourmanagement.entities.TourInformation;

public interface TourInformationService {

	TourInformation addTourInformation(TourInformationDto tourInformationDto);

	List<TourInformation> getAllTourInformations();

	TourInformation getTourInformationById(int tourInfoId);

	void deleteTourInformationsById(int tourInfoId);

	TourInformation updateTourInformation(TourInformation tourInformation);

	//
	List<TourInformationDto> getAllTourInformationsByTypeofTravel(String location, String typeOfTravel);

	List<TourInformationDto> getAllTourInformationsWithInSpan(String location, String startDate, String endDate);

	TourInformation getAllTourInformationByBookingId(int bookingId);

	List<TourInformationDto> getAllTourInformationsByCost(double cost);

	TourInformation getTourInformationByTourId(int tourId);

	List<TourInformationDto> getAllTourInformationsByLocation(String location);
}
