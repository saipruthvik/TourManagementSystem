package com.medplus.tourmanagement.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.tourmanagement.dto.CustomerInfoDto;
import com.medplus.tourmanagement.service.CustomerInfoService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CustomerInfoServiceTest {
	@Autowired
	CustomerInfoService customerInfoService;

	@Test
	@Order(1)
	void testAddCustomerInfoTest() {
		CustomerInfoDto customerInfoDto = new CustomerInfoDto();
		customerInfoDto.setCustomerAge(43);
		customerInfoDto.setCustomerName("sai");
		customerInfoDto.setPhoneNo(348734);
		assertNotNull(customerInfoService.addCustomerInfo(customerInfoDto));
	}

	@Test
	@Order(2)
	void testGetCustomerInfoByCustomerId() {
		assertNotNull(customerInfoService.getCustomerInfoByCustomerId(110001));
	}

	@Test
	@Order(3)
	void testGetAllCustomerInfo() {
		assertNotNull(customerInfoService.getAllCustomerInfo());
	}

	@Test
	@Order(4)
	void testUpdatePhoneNoWithCustomerIdTest() {
		assertNotNull(customerInfoService.updatePhoneNoWithCustomerId(110001, 987654320));
	}

	@Test
	@Order(5)
	void testUpdateAgeWithCustomerIdTest() {
		assertNotNull(customerInfoService.updateAgeWithCustomerId(110001, 25));
	}

	@Test
	@Order(6)
	void testUpdateNameWithCustomerIdTest() {
		assertNotNull(customerInfoService.updateNameWithCustomerId(110001, "kalidas"));
	}

	@Test
	@Order(7)
	void testUpdateCustomerInfo() {
		int customerId = 110001;
		CustomerInfoDto customerInfoDto = new CustomerInfoDto();
		customerInfoDto.setCustomerAge(33);
		customerInfoDto.setCustomerName("hello");
		customerInfoDto.setPhoneNo(387923334);
		assertNotNull(customerInfoService.updateCustomerInfo(customerId, customerInfoDto));
	}

}