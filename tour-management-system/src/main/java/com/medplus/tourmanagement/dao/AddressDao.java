package com.medplus.tourmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, String> {

	@Query(value = "select address from Address address where address.customerInfo.customerId = ?1")
	Address getAddressByCustomerId(int customerId);
}
