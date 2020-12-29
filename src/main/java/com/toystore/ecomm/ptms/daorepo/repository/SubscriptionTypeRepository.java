package com.toystore.ecomm.ptms.daorepo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.ptms.daorepo.model.SubscriptionTypeInfo;


@Repository
public interface SubscriptionTypeRepository extends CrudRepository<SubscriptionTypeInfo, Integer> {
	List<SubscriptionTypeInfo> findByPlanTypeId(Integer planTypeId);
	List<SubscriptionTypeInfo> findByPlanName(String planName);
}
