package com.medplus.tourmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.TourInformation;

@Repository
public interface TourInformationDao extends JpaRepository<TourInformation, Integer> {

	@Query(value = "select max(tourInfoId) from TourInformation")
	int getMaxTourInformationId();

	@Query(value = "select tourinfo from TourInformation tourinfo where tourinfo.location = ?1")
	List<TourInformation> getAllTourInformationsByLocation(String location);

	@Query(value = "select tourinfo from TourInformation tourinfo where tourinfo.location = ?1 and tourinfo.travelType = ?2")
	List<TourInformation> getAllTourInformationsByTypeofTravel(String location, String typeOfTravel);

	@Query(value = "select tourinfo from TourInformation tourinfo where tourinfo.location = ?1 and tourinfo.days <= ?2")
	List<TourInformation> getAllTourInformationsWithInSpan(String location, int days);

	@Query(value = "select tourinfo from TourInformation tourinfo where tourinfo.totalCost <= ?1")
	List<TourInformation> getAllTourInformationsByCost(double cost);

}
