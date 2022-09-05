package com.medplus.tourmanagement.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.tourmanagement.exceptions.PackageNotBookedException;
import com.medplus.tourmanagement.exceptions.TicketReservationAlreadyCancelledException;
import com.medplus.tourmanagement.exceptions.TourCompletedException;
import com.medplus.tourmanagement.service.TicketReservationService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TicketReservationServiceTest {

	@Autowired
	TicketReservationService ticketReservationService;

	@Test
	@Order(1)
	void testAddTicketReservationThrows() {
		assertThrows(TourCompletedException.class, () -> ticketReservationService.addTicketReservation(5502));
	}

	@Test
	@Order(2)
	void testCancelTicketReservationThrows() {
		assertThrows(TicketReservationAlreadyCancelledException.class,
				() -> ticketReservationService.cancelTicketReservation(1000));
	}

	@Test
	@Order(3)
	void testGetTicketReservationStatusThrows() {
		assertThrows(PackageNotBookedException.class,
				() -> ticketReservationService.getTicketReservationStatus(110000));

	}

	@Test
	@Order(4)
	void testGetTicketReservationStatuByIdFalse() {
		assertFalse(ticketReservationService.getTicketReservationStatuById(1000) == null);

	}

	@Test
	@Order(5)
	void testGetTicketReservationStatuByIdTrue() {
		assertTrue(ticketReservationService.getTicketReservationStatuById(1000) != null);
	}

}
