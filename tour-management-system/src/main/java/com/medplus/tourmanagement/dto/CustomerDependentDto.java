package com.medplus.tourmanagement.dto;

public class CustomerDependentDto {

	private int customerId;
	private String customerDependentName;
	private int customerDependentAge;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerDependentName() {
		return customerDependentName;
	}

	public void setCustomerDependentName(String customerDependentName) {
		this.customerDependentName = customerDependentName;
	}

	public int getCustomerDependentAge() {
		return customerDependentAge;
	}

	public void setCustomerDependentAge(int customerDependentAge) {
		this.customerDependentAge = customerDependentAge;
	}

}
