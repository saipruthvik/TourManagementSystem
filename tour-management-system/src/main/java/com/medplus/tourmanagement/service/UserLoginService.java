package com.medplus.tourmanagement.service;

import com.medplus.tourmanagement.entities.UserLogin;

public interface UserLoginService {

	UserLogin checkUserLogin(UserLogin userLogin);

	UserLogin addUser(String password, String userRole);

	UserLogin updateUserPassword(int userId, String password);

	UserLogin getPassword(int userId);
}
