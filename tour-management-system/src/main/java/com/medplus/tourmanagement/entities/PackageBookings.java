package com.medplus.tourmanagement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "packageBookings")
public class PackageBookings {

	@Id
	private int bookingId;
	@ManyToOne
	@JoinColumn(name = "tourInfoId")
	private TourInformation tourInformation;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerInfo customerInfo;
	@Column(name = "bookingstatus", length = 60)
	private String bookingStatus;
	@Column(name = "paymentType")
	private String paymentType;
	@Column(name = "tripDate")
	private Date tripDate;
	@Column
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

	public TourInformation getTourInformation() {
		return tourInformation;
	}

	public void setTourInformation(TourInformation tourInformation) {
		this.tourInformation = tourInformation;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
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
