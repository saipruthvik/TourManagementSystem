package com.medplus.tourmanagement.dto;

import java.util.Date;

public class PackageBookingsForStaffDto {
	private int bookingId;
	private TourInformationDto tourInformationDto;
	private CustomerInfoDto customerInfoDto;
	private String bookingStatus;
	private String paymentType;
	private Date tripDate;
	private int packageCost;

	public int getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public TourInformationDto getTourInformationDto() {
		return tourInformationDto;
	}

	public void setTourInformationDto(TourInformationDto tourInformationDto) {
		this.tourInformationDto = tourInformationDto;
	}

	public CustomerInfoDto getCustomerInfoDto() {
		return customerInfoDto;
	}

	public void setCustomerInfoDto(CustomerInfoDto customerInfoDto) {
		this.customerInfoDto = customerInfoDto;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}
}