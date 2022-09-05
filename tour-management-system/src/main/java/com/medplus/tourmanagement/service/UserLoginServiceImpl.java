package com.medplus.tourmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.tourmanagement.dao.UserLoginDao;
import com.medplus.tourmanagement.entities.UserLogin;
import com.medplus.tourmanagement.exceptions.UserDoesNotExistException;
import com.medplus.tourmanagement.exceptions.UserRoleDoesNotExistException;
import com.medplus.tourmanagement.exceptions.WrongUserPasswordException;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserLoginDao userLoginDao;

	@Override
	public UserLogin checkUserLogin(UserLogin userLogin) {
		Optional<UserLogin> user = userLoginDao.findById(userLogin.getUserId());
		if (user.isEmpty())
			throw new UserDoesNotExistException();
		if (user.get().getPassword().equals(userLogin.getPassword())) {
			return user.get();
		} else
			throw new WrongUserPasswordException();
	}

	@Override
	public UserLogin addUser(String password, String userRole) {
		int userId = userLoginDao.getMaxUserId();
		if (userId == 0)
			userId = 2220000;
		else
			userId++;
		UserLogin user = new UserLogin();
		user.setUserId(userId);
		user.setPassword(password);
		if (userRole.equals("admin") || userRole.equals("staff"))
			user.setUserRole(userRole);
		else
			throw new UserRoleDoesNotExistException();
		return userLoginDao.save(user);
	}

	@Override
	public UserLogin updateUserPassword(int userId, String password) {
		Optional<UserLogin> userLogin = userLoginDao.findById(userId);
		if (userLogin.isEmpty())
			throw new UserDoesNotExistException();
		userLogin.get().setPassword(password);
		return userLoginDao.save(userLogin.get());
	}

	@Override
	public UserLogin getPassword(int userId) {
		if (userLoginDao.findById(userId).isEmpty()) {
			throw new UserDoesNotExistException();
		}
		return userLoginDao.findById(userId).get();
	}

}
