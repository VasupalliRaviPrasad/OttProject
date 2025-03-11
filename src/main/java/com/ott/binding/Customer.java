package com.ott.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Customer {
	
	private String customerName;
	private String ottSubscribed;
	private Integer numOfMonths;
	private String paymentMethod;
	private LocalDate dateOfSubscription;

}
