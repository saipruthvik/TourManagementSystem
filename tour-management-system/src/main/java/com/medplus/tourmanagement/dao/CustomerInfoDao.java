package com.medplus.tourmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.CustomerInfo;

@Repository
public interface CustomerInfoDao extends JpaRepository<CustomerInfo, Integer> {

	@Query(value = "select max(customerId) from CustomerInfo")
	int getMaxCustomerId();

	@Query(value = "select custInfo from CustomerInfo custInfo where custInfo.userLogin.userId = :userId")
	CustomerInfo getCustomerInfoByUserId(@Param("userId") int userId);

}
