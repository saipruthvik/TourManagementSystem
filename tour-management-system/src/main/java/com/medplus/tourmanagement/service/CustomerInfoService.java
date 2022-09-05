package com.medplus.tourmanagement.service;

import java.util.List;

import com.medplus.tourmanagement.dto.CustomerInfoDto;
import com.medplus.tourmanagement.entities.CustomerInfo;

public interface CustomerInfoService {

	CustomerInfo addCustomerInfo(CustomerInfoDto customerInfoDto);

	CustomerInfo updateNameWithCustomerId(int customerId, String customerName);

	CustomerInfo updatePhoneNoWithCustomerId(int customerId, long phoneNo);

	CustomerInfo updateAgeWithCustomerId(int customerId, int customerAge);

	CustomerInfo updateCustomerInfo(int customerId, CustomerInfoDto customerInfoDto);

	CustomerInfo getCustomerInfoByCustomerId(int customerId);

	List<CustomerInfo> getAllCustomerInfo();

	CustomerInfo getCustomerInfoByUserId(int userId);
}
