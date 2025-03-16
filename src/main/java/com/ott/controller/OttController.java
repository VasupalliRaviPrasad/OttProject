package com.ott.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ott.binding.Customer;
import com.ott.binding.Subscription;
import com.ott.service.OttService;

@RestController
public class OttController {

	private OttService ottService;

	public OttController(OttService ottService) {
		super();
		this.ottService = ottService;
	}

	@PostMapping("/subscribe")
	public ResponseEntity<Subscription> controllerSubscribe(@RequestBody Customer customer) {
		Subscription subscribe = ottService.subscribe(customer);
		return new ResponseEntity<Subscription>(subscribe, HttpStatus.OK);
	}
	
	@GetMapping("/subscriptionDetails/{uniqueRefNum}")
	public ResponseEntity<Subscription> controllerSubscriptionDetails(@PathVariable String uniqueRefNum){
		Subscription subscriptionDetails = ottService.getMySubscriptions(uniqueRefNum);
		return new ResponseEntity<Subscription>(subscriptionDetails, HttpStatus.OK);
	}
	
	@PutMapping("/updateDetails/{uniqueRefNum}")
	public ResponseEntity<Subscription> controllerUpdateDetails(@PathVariable String uniqueRefNum, @RequestBody Customer customer){
		Subscription updateSubscription = ottService.updateSubscription(uniqueRefNum, customer);
		return new ResponseEntity<Subscription>(updateSubscription, HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelSubscription/{uniqueRefNum}")
	public ResponseEntity<String> controllerCancelTicket(@PathVariable String uniqueRefNum){
		Boolean cancelSubscription = ottService.cancelSubscription(uniqueRefNum);
		if(cancelSubscription) {
			return new ResponseEntity<String>("Subscription cancelled successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("There is no active subscription with the given reference number", HttpStatus.OK);
	}
	
	

}
