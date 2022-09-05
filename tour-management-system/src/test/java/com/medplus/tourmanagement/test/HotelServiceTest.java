//package com.medplus.tourmanagement.test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.medplus.tourmanagement.dto.HotelDto;
//import com.medplus.tourmanagement.exceptions.LocationDoesNotExistException;
//import com.medplus.tourmanagement.service.HotelService;
//
//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//public class HotelServiceTest {
//	@Autowired
//	HotelService hotelService;
//
//	@Test
//	@Order(1)
//	void testAddHotelNotNull() {
//		HotelDto hotelDto = new HotelDto();
//		hotelDto.setHotelDescription("checking hotel");
//		hotelDto.setHotelName("checkhotel");
//		hotelDto.setHotelServiceCost(5000);
//		hotelDto.setLocation("Pune");
//		List<String> roomsList = new ArrayList<String>();
//		roomsList.add("Non-Ac Single Bedoom");
//		roomsList.add("Ac Single Bedoom");
//		hotelDto.setTypeOfRoom(roomsList);
//		assertNotNull(hotelService.addHotel(hotelDto));
//	}
//
//	@Test
//	@Order(2)
//	void testAddHotelTrue() {
//		HotelDto hotelDto = new HotelDto();
//		hotelDto.setHotelDescription("checking hotel");
//		hotelDto.setHotelName("new hotel");
//		hotelDto.setHotelServiceCost(5000);
//		hotelDto.setLocation("Pune");
//		List<String> roomsList = new ArrayList<String>();
//		roomsList.add("Non-Ac Single Bedoom");
//		roomsList.add("Ac Single Bedoom");
//		hotelDto.setTypeOfRoom(roomsList);
//		assertTrue(hotelService.addHotel(hotelDto) != null);
//	}
//
//	@Test
//	@Order(3)
//	void testGetHotelsByLocationNotNull() {
//		assertNotNull(hotelService.getHotelsByLocation("Hyderabad"));
//	}
//
//	@Test
//	@Order(4)
//	void testGetHotelsByLocationTrue() {
//		assertTrue(hotelService.getHotelsByLocation("Hyderabad") != null);
//	}
//
//	@Test
//	@Order(5)
//	void testUpdateHotelRoomsListByNameNotNull() {
//		List<String> roomsList = new ArrayList<String>();
//		roomsList.add("Non-Ac Double Bedoom");
//		roomsList.add("Ac Double Bedoom");
//		assertNotNull(hotelService.updateHotelRoomsListByName("checkhotel", roomsList));
//	}
//
//	@Test
//	@Order(6)
//	void testUpdateHotelRoomsListByNameFalse() {
//		List<String> roomsList = new ArrayList<String>();
//		roomsList.add("Non-Ac Double Bedoom");
//		roomsList.add("Ac Double Bedoom");
//		assertFalse(hotelService.updateHotelRoomsListByName("new hotel", roomsList) == null);
//	}
//
//	@Test
//	@Order(7)
//	void testGetAllHotelsNotNull() {
//		assertNotNull(hotelService.getAllHotels());
//	}
//
//	@Test
//	@Order(8)
//	void testGetAllHotels() {
//		assertTrue(hotelService.getAllHotels() != null);
//	}
//
//	@Test
//	@Order(9)
//	void updateHotelDescriptionByNameNotNull() {
//		assertNotNull(hotelService.updateHotelDescriptionByName("checkhotel", "Check Description updated"));
//	}
//
//	@Test
//	@Order(10)
//	void updateHotelDescriptionByNameFalse() {
//		assertFalse(hotelService.updateHotelDescriptionByName("new hotel", "Check Description updated") == null);
//	}
//
//	@Test
//	@Order(11)
//	void testUpdateHotelServiceCostByNameFalse() {
//		assertFalse(hotelService.updateHotelServiceCostByName("checkhotel", 5000) == null);
//	}
//
//	@Test
//	@Order(12)
//	void testUpdateHotelServiceCostByNameTrue() {
//		assertTrue(hotelService.updateHotelServiceCostByName("new hotel", 5000) != null);
//	}
//
//	@Test
//	@Order(13)
//	void testUpdateHotelTrue() {
//		List<String> roomsList = new ArrayList<String>();
//		roomsList.add("Non-Ac Single Bedoom");
//		roomsList.add("Ac Single Bedoom");
//		roomsList.add("Non-Ac Double Bedoom");
//		roomsList.add("Ac Double Bedoom");
//		assertTrue(hotelService.updateHotel("checkhotel", "Total hotel update description", 10000, roomsList) != null);
//	}
//
//	@Test
//	@Order(14)
//	void testUpdateHotelFalse() {
//		List<String> roomsList = new ArrayList<String>();
//		roomsList.add("Non-Ac Single Bedoom");
//		roomsList.add("Ac Single Bedoom");
//		roomsList.add("Non-Ac Double Bedoom");
//		roomsList.add("Ac Double Bedoom");
//		assertFalse(
//				hotelService.updateHotel("new hotel", "Total new hotel update description", 10000, roomsList) == null);
//	}
//
//	@Test
//	@Order(15)
//	void testDeleteHotel() {
//		hotelService.deleteHotel("checkhotel");
//		hotelService.deleteHotel("new hotel");
//		assertThrows(LocationDoesNotExistException.class, () -> hotelService.getHotelsByLocation("Pune"));
//	}
//}
