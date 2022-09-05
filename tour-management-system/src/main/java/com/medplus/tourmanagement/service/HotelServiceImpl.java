package com.medplus.tourmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.tourmanagement.dao.HotelDao;
import com.medplus.tourmanagement.dto.HotelDto;
import com.medplus.tourmanagement.entities.Hotel;
import com.medplus.tourmanagement.exceptions.EmptyHotelsListException;
import com.medplus.tourmanagement.exceptions.HotelDoesNotExistException;
import com.medplus.tourmanagement.exceptions.LocationDoesNotExistException;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hotelDao;

	@Override
	public Hotel addHotel(HotelDto hotelDto) {
		List<Hotel> hotelList = hotelDao.findAll();
		int hotelId = 0;
		if (hotelList.isEmpty())
			hotelId = 101;
		else {
			hotelId = hotelDao.getMaxHotelId();
			hotelId++;
		}
		Hotel hotel = new Hotel();
		hotel.setHotelId(hotelId);
		hotel.setHotelName(hotelDto.getHotelName());
		hotel.setHotelDescription(hotelDto.getHotelDescription());
		hotel.setLocation(hotelDto.getLocation());
		hotel.setHotelServiceCost(hotelDto.getHotelServiceCost());
		hotel.setRoomType(hotelDto.getRoomType());
		return hotelDao.save(hotel);
	}

	@Override
	public List<Hotel> getHotelsByLocationAndCost(String location, double totalCost) {
		return hotelDao.getHotelsByLocationAndCost(location, totalCost);
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotelList = hotelDao.findAll();

		if (hotelList.isEmpty())
			throw new EmptyHotelsListException();
		return hotelList;
	}

	@Override
	public List<Hotel> getHotelsByLocation(String location) {
		List<Hotel> hotelList = hotelDao.getHotelsByLocation(location);
		if (hotelList.isEmpty())
			throw new LocationDoesNotExistException();

		if (hotelList.isEmpty())
			throw new EmptyHotelsListException();
		return hotelList;
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		if (hotel == null)
			throw new HotelDoesNotExistException();
		return hotel.get();
	}

	@Override
	public void deleteHotelById(int hotelId) {
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		if (hotel.isEmpty()) {
			throw new HotelDoesNotExistException();
		}
		hotelDao.deleteById(hotelId);

	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		Optional<Hotel> hotel1 = hotelDao.findById(hotel.getHotelId());
		if (hotel1 == null) {
			throw new HotelDoesNotExistException();
		}
		return hotelDao.save(hotel);
	}
}
