package com.ott.service;

import org.springframework.stereotype.Service;

import com.ott.binding.Customer;
import com.ott.binding.Subscription;

@Service
public class OttServicePrice {
	
	public Integer priceOfSubscription(Customer customer) {
		Subscription subscription = new Subscription();
		if(customer.getOttSubscribed().equalsIgnoreCase("Netflix")) {
			subscription.setTotalAmount(customer.getNumOfMonths()*1200);
		}
		else if (customer.getOttSubscribed().equalsIgnoreCase("Amazon Prime")){
			subscription.setTotalAmount(customer.getNumOfMonths()*1000);
		}
		return subscription.getTotalAmount();
	}

}
