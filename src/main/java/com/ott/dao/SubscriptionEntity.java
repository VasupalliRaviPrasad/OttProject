package com.ott.dao;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SubscriptionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sno;
	private String uniqueRefNum;
	private String customerName;
	private String ottSubscribed;
	private Integer numOfMonths;
	private Integer totalAmount;
	private String paymentStatus;
	private LocalDate validityOfSubscription;

}
