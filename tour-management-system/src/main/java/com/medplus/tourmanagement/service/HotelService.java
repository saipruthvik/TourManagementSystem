package com.medplus.tourmanagement.service;

import java.util.List;

import com.medplus.tourmanagement.dto.HotelDto;
import com.medplus.tourmanagement.entities.Hotel;

public interface HotelService {

	Hotel addHotel(HotelDto hotelDto);

	List<Hotel> getHotelsByLocation(String location);

	Hotel getHotelById(int hotelId);

	List<Hotel> getAllHotels();

	void deleteHotelById(int hotelId);

	Hotel updateHotel(Hotel hotel);

	List<Hotel> getHotelsByLocationAndCost(String location, double totalCost);
}