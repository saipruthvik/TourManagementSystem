package com.medplus.tourmanagement.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.tourmanagement.dao.TourInformationDao;
import com.medplus.tourmanagement.dto.TourInformationDto;
import com.medplus.tourmanagement.exceptions.TourInformationDoesNotExistException;
import com.medplus.tourmanagement.service.TourInformationService;

@SpringBootTest
public class TourInformationServiceTest {
	@Autowired
	TourInformationService tourInformationService;
	@Autowired
	TourInformationDao tourInformationDao;

	@Test
	@Order(1)
	void testAddTourInformationNotNull() {
		TourInformationDto tourInformationDto = new TourInformationDto();
		tourInformationDto.setLocation("chennai");
		tourInformationDto.setTravelType("flight");
		tourInformationDto.setTourDescription("good to go");
		tourInformationDto.setTotalCost(1200);
		tourInformationDto.setDays(7);
		assertNotNull(tourInformationService.addTourInformation(tourInformationDto));

	}

	@Test
	@Order(2)
	void testAddTourInformationTrue() {
		TourInformationDto tourInformationDto = new TourInformationDto();

		tourInformationDto.setLocation("chennai");
		tourInformationDto.setTravelType("flight");
		tourInformationDto.setTourDescription("good to go");
		tourInformationDto.setTotalCost(1200);
		tourInformationDto.setDays(7);
		assertTrue(tourInformationService.addTourInformation(tourInformationDto) != null);

	}

	@Test
	@Order(3)
	void testGetAllTourInformationsNotNull() {
		assertNotNull(tourInformationService.getAllTourInformations());
	}

	@Test
	@Order(4)
	void testGetAllTourInformationsTrue() {
		assertTrue(tourInformationService.getAllTourInformations() != null);

	}

	@Test
	@Order(5)
	void testGetAllTourInformationsByLocationNotNull() {
		assertNotNull(tourInformationService.getAllTourInformationsByLocation("chennai"));
	}

	@Test
	@Order(6)
	void testGetAllTourInformationsByLocationTrue() {
		assertTrue(tourInformationService.getAllTourInformationsByLocation("chennai") != null);
	}

//	@Test
//	@Order(7)
//	void testUpdateDescriptionByIdNotNull() {
//		assertNotNull(tourInformationService.updateDescriptionById(1121, "Checking Description"));
//
//	}
//
//	@Test
//	@Order(8)
//	void testUpdateDescriptionByIdTrue() {
//		assertTrue(tourInformationService.updateDescriptionById(1121, "Checking Description") != null);
//
//	}
//
//	@Test
//	@Order(9)
//	void testUpdateTotalCostByIdTrue() {
//		assertTrue(tourInformationService.updateTotalCostById(1121, 3400) != null);
//	}
//
//	@Test
//	@Order(10)
//	void testUpdateTotalCostByIdFalse() {
//		assertFalse(tourInformationService.updateTotalCostById(1121, 3400) == null);
//	}
//
//	@Test
//	@Order(11)
//	void testUpdateDaysByIdNotNull() {
//		assertNotNull(tourInformationService.updateTotalCostById(1121, 8));
//	}
//
//	@Test
//	@Order(12)
//	void testUpdateDaysByIdFalse() {
//		assertFalse(tourInformationService.updateTotalCostById(1121, 8) == null);
//	}
//
//	@Test
//	@Order(13)
//	void testUpdateTourInformationByIdNotNull() {
//		assertNotNull(tourInformationService.updateTourInformationById(1121, "happy to go", 30000, 7));
//	}
//
//	@Test
//	@Order(14)
//	void testUpdateTourInformationByIdTrue() {
//		assertTrue(tourInformationService.updateTourInformationById(1121, "happy to go", 30000, 7) != null);
//	}

	@Test
	@Order(15)
	void testDeleteTourInformationsByIdThrows() {
		assertThrows(TourInformationDoesNotExistException.class,
				() -> tourInformationService.deleteTourInformationsById(19209));
	}

//	@Test
//	@Order(16)
//	void testDeleteTourInformationsByLocationThrows() {
//		assertThrows(LocationDoesNotExistException.class,
//				() -> tourInformationService.deleteTourInformationsByLocation("mumbai"));
//	}
}