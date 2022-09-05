//package com.medplus.tourmanagement.test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.medplus.tourmanagement.dto.AddressDto;
//import com.medplus.tourmanagement.exceptions.AddressDoesNotExistException;
//import com.medplus.tourmanagement.service.AddressService;
//
//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//public class AddressServiceTest {
//
//	@Autowired
//	AddressService addressService;
//
//	@Test
//	@Order(1)
//	void testAddAddressFalse() {
//		AddressDto addressDto = new AddressDto();
//		addressDto.setHouseNo("102306");
//		addressDto.setCity("hyderabad");
//		addressDto.setPincode(500055);
//		addressDto.setState("telangana");
//		addressDto.setStreet("ramampur");
//		addressDto.setCustomerId(110001);
//		assertFalse(addressService.addAddress(addressDto) == null);
//	}
//
//	@Test
//	@Order(2)
//	void testAddAddressTrue() {
//		AddressDto addressDto = new AddressDto();
//		addressDto.setHouseNo("102305");
//		addressDto.setCity("hyderabad");
//		addressDto.setPincode(500055);
//		addressDto.setState("telangana");
//		addressDto.setStreet("ramampur");
//		addressDto.setCustomerId(110002);
//		assertTrue(addressService.addAddress(addressDto) != null);
//	}
//
//	@Test
//	@Order(3)
//	void testGetAddressByCustomerIdServiceFalse() {
//		assertFalse(addressService.getAddressByCustomerId(110001) == null);
//	}
//
//	@Test
//	@Order(4)
//	void testGetAddressByCustomerIdServiceTrue() {
//		assertTrue(addressService.getAddressByCustomerId(110002) != null);
//	}
//
//	@Test
//	@Order(5)
//	void testUpdateAddressFalse() {
//		AddressDto addressDto = new AddressDto();
//		addressDto.setHouseNo("102306");
//		addressDto.setCity("hyderabad");
//		addressDto.setPincode(500055);
//		addressDto.setState("telangana");
//		addressDto.setStreet("kazeepet");
//		assertFalse(addressService.updateAddress(addressDto) == null);
//	}
//
//	@Test
//	@Order(6)
//	void testUpdateAddressTrue() {
//		AddressDto addressDto = new AddressDto();
//		addressDto.setHouseNo("102305");
//		addressDto.setCity("hyderabad");
//		addressDto.setPincode(500055);
//		addressDto.setState("telangana");
//		addressDto.setStreet("kazeepet");
//		assertTrue(addressService.updateAddress(addressDto) != null);
//	}
//
//	@Test
//	@Order(7)
//	void testDeleteAddressThrows() {
//		addressService.deleteAddress(110001);
//		addressService.deleteAddress(110002);
//		assertThrows(AddressDoesNotExistException.class, () -> addressService.getAddressByCustomerId(110001));
//	}
//
//}