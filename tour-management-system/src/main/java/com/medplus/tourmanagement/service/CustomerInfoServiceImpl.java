package com.medplus.tourmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.tourmanagement.dao.CustomerInfoDao;
import com.medplus.tourmanagement.dao.UserLoginDao;
import com.medplus.tourmanagement.dto.CustomerInfoDto;
import com.medplus.tourmanagement.entities.CustomerInfo;
import com.medplus.tourmanagement.entities.UserLogin;
import com.medplus.tourmanagement.exceptions.CustomerDoesNotExistException;
import com.medplus.tourmanagement.exceptions.EmptyCustomersListException;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	CustomerInfoDao customerInfoDao;

	@Autowired
	UserLoginDao userLoginDao;

	@Override
	public CustomerInfo addCustomerInfo(CustomerInfoDto customerInfoDto) {
		List<CustomerInfo> customerInfosList = customerInfoDao.findAll();
		int customerId = 0;
		if (customerInfosList.isEmpty())
			customerId = 110000;
		else {
			customerId = customerInfoDao.getMaxCustomerId();
			customerId++;
		}
		List<UserLogin> userLoginsList = userLoginDao.findAll();
		int userId = 0;
		if (userLoginsList.isEmpty())
			userId = 2220000;
		else {
			userId = userLoginDao.getMaxUserId();
			userId++;
		}
		String password = customerInfoDto.getCustomerName();
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(userId);
		userLogin.setPassword(password);
		userLogin.setUserRole("customer");
		userLoginDao.save(userLogin);
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomerId(customerId);
		customerInfo.setCustomerName(customerInfoDto.getCustomerName());
		customerInfo.setCustomerAge(customerInfoDto.getCustomerAge());
		customerInfo.setPhoneNo(customerInfoDto.getPhoneNo());
		customerInfo.setUserLogin(userLogin);
		return customerInfoDao.save(customerInfo);
	}

	@Override
	public CustomerInfo updateNameWithCustomerId(int customerId, String customerName) {
		Optional<CustomerInfo> customerInfo = customerInfoDao.findById(customerId);
		if (customerInfo.isEmpty())
			throw new CustomerDoesNotExistException();
		customerInfo.get().setCustomerName(customerName);
		return customerInfoDao.save(customerInfo.get());
	}

	@Override
	public CustomerInfo updatePhoneNoWithCustomerId(int customerId, long phoneNo) {
		Optional<CustomerInfo> customerInfo = customerInfoDao.findById(customerId);
		if (customerInfo.isEmpty())
			throw new CustomerDoesNotExistException();
		customerInfo.get().setPhoneNo(phoneNo);
		return customerInfoDao.save(customerInfo.get());
	}

	@Override
	public CustomerInfo updateAgeWithCustomerId(int customerId, int customerAge) {
		Optional<CustomerInfo> customerInfo = customerInfoDao.findById(customerId);
		if (customerInfo.isEmpty())
			throw new CustomerDoesNotExistException();
		customerInfo.get().setCustomerAge(customerAge);
		return customerInfoDao.save(customerInfo.get());
	}

	@Override
	public CustomerInfo updateCustomerInfo(int customerId, CustomerInfoDto customerInfoDto) {
		Optional<CustomerInfo> customerInfo = customerInfoDao.findById(customerId);
		if (customerInfo.isEmpty())
			throw new CustomerDoesNotExistException();
		customerInfo.get().setCustomerName(customerInfoDto.getCustomerName());
		customerInfo.get().setCustomerAge(customerInfoDto.getCustomerAge());
		customerInfo.get().setPhoneNo(customerInfoDto.getPhoneNo());
		return customerInfoDao.save(customerInfo.get());
	}

	@Override
	public CustomerInfo getCustomerInfoByCustomerId(int customerId) {
		Optional<CustomerInfo> customerInfo = customerInfoDao.findById(customerId);
		if (customerInfo.isEmpty())
			throw new CustomerDoesNotExistException();
//		CustomerInfoDto customerInfoDto = new CustomerInfoDto();
//		customerInfoDto.setCustomerAge(customerInfo.get().getCustomerAge());
//		customerInfoDto.setCustomerName(customerInfo.get().getCustomerName());
//		customerInfoDto.setPhoneNo(customerInfo.get().getPhoneNo());
		return customerInfo.get();
	}

	@Override
	public List<CustomerInfo> getAllCustomerInfo() {
		List<CustomerInfo> customerInfoList = customerInfoDao.findAll();
		if (customerInfoList.isEmpty())
			throw new EmptyCustomersListException();
//		List<CustomerInfoDto> customerInfoDtosList = new ArrayList<>();
//		for (CustomerInfo customerInfo : customerInfoList) {
//			CustomerInfoDto customerInfoDto = new CustomerInfoDto();
//			customerInfoDto.setCustomerAge(customerInfo.getCustomerAge());
//			customerInfoDto.setCustomerName(customerInfo.getCustomerName());
//			customerInfoDto.setPhoneNo(customerInfo.getPhoneNo());
//			customerInfoDtosList.add(customerInfoDto);
//		}

		return customerInfoList;
	}

	@Override
	public CustomerInfo getCustomerInfoByUserId(int userId) {
		return customerInfoDao.getCustomerInfoByUserId(userId);
	}

}
