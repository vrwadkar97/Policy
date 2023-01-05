package com.policy.service;

import java.util.List;

import com.policy.entity.Policy;

public interface Service {
	
	public Policy addPolicy(Policy policy);
	
//	public Policy getPolicy(Integer id);
//	
//	public Policy getPolicy(String category);
	
	public List<Policy> getAllPolicies(Integer pageNumber,Integer pageSize,String input, String dir);
	
	public Policy updatePolicy(Policy policy, Integer id);
	
	public Policy updateByPatch(Policy policy, Integer id);
	
	

}
