package com.ott.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Subscription {
	
	private String uniqueRefNum;
	private String customerName;
	private String ottSubscribed;
	private Integer numOfMonths;
	private Integer totalAmount;
	private String paymentStatus;
	private LocalDate validityOfSubscription;
	

}
