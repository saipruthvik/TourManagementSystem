package com.medplus.tourmanagement.service;

import com.medplus.tourmanagement.dto.AddressDto;
import com.medplus.tourmanagement.entities.Address;

public interface AddressService {

	Address getAddressByCustomerId(int customerId);

	Address updateAddress(AddressDto addressDto);

	void deleteAddress(int customerId);

	Address addAddress(Address address);
}
