package com.medplus.tourmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.tourmanagement.dao.AddressDao;
import com.medplus.tourmanagement.dao.CustomerInfoDao;
import com.medplus.tourmanagement.dto.AddressDto;
import com.medplus.tourmanagement.entities.Address;
import com.medplus.tourmanagement.exceptions.AddressDoesNotExistException;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;

	@Autowired
	CustomerInfoDao customerInfoDao;

	@Override
	public Address addAddress(Address address) {
//		if (addressDao.findById(addressDto.getHouseNo()).isEmpty()) {
//			Optional<CustomerInfo> customerInfo = customerInfoDao.findById(addressDto.getCustomerId());
//			if (customerInfo.isEmpty())
//				throw new CustomerDoesNotExistException();
//			Address address = addressDao.getAddressByCustomerId(addressDto.getCustomerId());
//			if (address == null) {
//				Address address2 = new Address();
//				address2.setHouseNo(addressDto.getHouseNo());
//				address2.setStreet(addressDto.getStreet());
//				address2.setCity(addressDto.getCity());
//				address2.setState(addressDto.getState());
//				address2.setPincode(addressDto.getPincode());
//				address2.setCustomerInfo(customerInfo.get());
//				return addressDao.save(address2);
//			} else
//				throw new CustomerAddressAlreadyExistException();
//
//		} else
//			throw new AddressAlreadyExistException();
		return addressDao.save(address);
	}

	@Override
	public Address getAddressByCustomerId(int customerId) {
		Address address = addressDao.getAddressByCustomerId(customerId);
		if (address != null) {
//			AddressDto addressDto = new AddressDto();
//			addressDto.setHouseNo(address.getHouseNo());
//			addressDto.setStreet(address.getStreet());
//			addressDto.setCity(address.getCity());
//			addressDto.setState(address.getState());
//			addressDto.setPincode(address.getPincode());
			return address;
		} else
			throw new AddressDoesNotExistException();
	}

	@Override
	public Address updateAddress(AddressDto addressDto) {
		Optional<Address> address = addressDao.findById(addressDto.getHouseNo());
		if (address.isPresent()) {
			address.get().setHouseNo(addressDto.getHouseNo());
			address.get().setStreet(addressDto.getStreet());
			address.get().setCity(addressDto.getCity());
			address.get().setState(addressDto.getState());
			address.get().setPincode(addressDto.getPincode());
			return addressDao.save(address.get());
		} else
			throw new AddressDoesNotExistException();
	}

	@Override
	public void deleteAddress(int customerId) {
		Address address = addressDao.getAddressByCustomerId(customerId);
		if (address == null)
			throw new AddressDoesNotExistException();
		addressDao.deleteById(address.getHouseNo());

	}

}
