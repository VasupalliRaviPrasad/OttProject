package com.ott.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ott.binding.Customer;
import com.ott.binding.Subscription;
import com.ott.dao.CustomerEntity;
import com.ott.dao.CustomerRepo;
import com.ott.dao.SubscriptionEntity;
import com.ott.dao.SubscriptionRepo;

@Service
public class OttServiceImp implements OttService {

	private CustomerRepo customerRepo;
	private SubscriptionRepo subscriptionRepo;
	private OttServicePrice ottServicePrice;

	public OttServiceImp(CustomerRepo customerRepo, SubscriptionRepo subscriptionRepo,
			OttServicePrice ottServicePrice) {
		this.customerRepo = customerRepo;
		this.subscriptionRepo = subscriptionRepo;
		this.ottServicePrice = ottServicePrice;
	}

	@Override
	public Subscription subscribe(Customer customer) {
		String uniqueRefNum = "";
		for (int i = 1; i <= 8; i++) {
			uniqueRefNum = uniqueRefNum + (int) (Math.random() * 10);
		}

		Subscription subscriber = new Subscription();
		subscriber.setCustomerName(customer.getCustomerName());
		subscriber.setNumOfMonths(customer.getNumOfMonths());
		subscriber.setOttSubscribed(customer.getOttSubscribed());
		subscriber.setPaymentStatus("Successful");
		subscriber.setTotalAmount(ottServicePrice.priceOfSubscription(customer));
		subscriber.setUniqueRefNum(uniqueRefNum);
		subscriber.setValidityOfSubscription(
				customer.getDateOfSubscription().now().plusMonths(customer.getNumOfMonths()));

		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customer, customerEntity);
		customerRepo.save(customerEntity);

		SubscriptionEntity subscriberEntity = new SubscriptionEntity();
		BeanUtils.copyProperties(subscriber, subscriberEntity);
		subscriptionRepo.save(subscriberEntity);

		return subscriber;
	}

	@Override
	public Subscription getMySubscriptions(String uniqueRefNum) {
		SubscriptionEntity byUniqueRefNum = subscriptionRepo.findByUniqueRefNum(uniqueRefNum);
		Subscription subscriptionDetails = new Subscription();
		BeanUtils.copyProperties(byUniqueRefNum, subscriptionDetails);
		return subscriptionDetails;
	}

	@Override
	public Subscription updateSubscription(String uniqueRefNum, Customer customer) {
		SubscriptionEntity byUniqueRefNum = subscriptionRepo.findByUniqueRefNum(uniqueRefNum);
		if (byUniqueRefNum!=null) {
			byUniqueRefNum.setNumOfMonths(customer.getNumOfMonths());
			byUniqueRefNum.setTotalAmount(ottServicePrice.priceOfSubscription(customer));
			byUniqueRefNum.setOttSubscribed(customer.getOttSubscribed());
			Subscription updateDetails = new Subscription();
			BeanUtils.copyProperties(byUniqueRefNum, updateDetails);
			return updateDetails;
		}
		return null;
		
	}

	@Override
	public Boolean cancelSubscription(String uniqueRefNum) {
		SubscriptionEntity hasSubscription = subscriptionRepo.findByUniqueRefNum(uniqueRefNum);
		if(hasSubscription!= null) {
			return true;
		}
		return false;
	}

}
