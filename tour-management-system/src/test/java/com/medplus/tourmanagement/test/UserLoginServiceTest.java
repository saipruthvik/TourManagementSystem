package com.medplus.tourmanagement.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medplus.tourmanagement.entities.UserLogin;
import com.medplus.tourmanagement.service.UserLoginService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserLoginServiceTest {

	@Autowired
	UserLoginService userLoginService;

	@Test
	@Order(1)
	void testAddUserNotNull() {
		assertNotNull(userLoginService.addUser("Kalidas", "staff"));
	}

	@Test
	@Order(2)
	void testUpdateUserPasswordTrue() {
		assertTrue(userLoginService.updateUserPassword(2220003, "Nayak") != null);
	}

	@Test
	@Order(3)
	void testCheckUserLoginNotNull() {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(2220003);
		userLogin.setPassword("Nayak");
		userLogin.setUserRole("staff");
		assertNotNull(userLoginService.checkUserLogin(userLogin));
	}

	@Test
	@Order(4)
	void testAddUserFalse() {
		assertFalse(userLoginService.addUser("Kalidas", "staff") == null);
	}

	@Test
	@Order(5)
	void testUpdateUserPasswordFalse() {
		assertFalse(userLoginService.updateUserPassword(2220004, "Check") == null);
	}

	@Test
	@Order(6)
	void testCheckUserLoginTrueNotNull() {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(2220004);
		userLogin.setPassword("Check");
		userLogin.setUserRole("staff");
		assertNotNull(userLoginService.checkUserLogin(userLogin));
	}

}
