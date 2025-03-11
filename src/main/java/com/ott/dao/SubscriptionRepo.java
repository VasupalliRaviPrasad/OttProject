package com.ott.dao;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriptionRepo extends JpaRepository<SubscriptionEntity, Integer>{
	
	public SubscriptionEntity findByUniqueRefNum(String uniqueRefNum);

}
