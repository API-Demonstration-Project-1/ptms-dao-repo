package com.toystore.ecomm.ptms.daorepo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toystore.ecomm.ptms.daorepo.model.RenewalTypeInfo;


@Repository
public interface RenewalTypeRepository extends CrudRepository<RenewalTypeInfo, Integer> {
	List<RenewalTypeInfo> findByRenewalName(String renewalName);
}
	
