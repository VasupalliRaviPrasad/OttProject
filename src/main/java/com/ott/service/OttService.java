package com.ott.service;

import com.ott.binding.Customer;
import com.ott.binding.Subscription;

public interface OttService {
	
	public Subscription subscribe(Customer customer);
	public Subscription getMySubscriptions(String uniqueRefNum);
	public Subscription updateSubscription(String uniqueRefNum, Customer customer);

}
