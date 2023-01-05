package com.policy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.entity.Policy;

public interface Repository extends JpaRepository<Policy, Integer>{
	
	public Policy findByPolicyId(Integer policyId);

}
