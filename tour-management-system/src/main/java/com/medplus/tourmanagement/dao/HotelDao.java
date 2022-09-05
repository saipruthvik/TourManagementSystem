package com.medplus.tourmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.Hotel;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

	@Query(value = "select max(hotelId) from Hotel")
	int getMaxHotelId();

	@Query(value = "select hotel from Hotel hotel where hotel.hotelName = ?1")
	Hotel getHotelByName(String hotelName);

	@Query(value = "select hotel from Hotel hotel where hotel.location = ?1")
	List<Hotel> getHotelsByLocation(String location);

	@Query(value = "select hotel from Hotel hotel where hotel.location=?1 and hotel.hotelServiceCost<=?2")
	List<Hotel> getHotelsByLocationAndCost(String location, double cost);
}
