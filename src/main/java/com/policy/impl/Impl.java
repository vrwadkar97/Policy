package com.policy.impl;

import java.util.List;

import javax.persistence.PersistenceUtil;

import org.hibernate.annotations.SortType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.policy.dao.Repository;
import com.policy.entity.Policy;
import com.policy.service.Service;

@org.springframework.stereotype.Service
public class Impl implements Service{
	
	Logger log=LoggerFactory.getLogger(Impl.class);
	
	@Autowired
	private Repository repo;

	@Override
	public Policy addPolicy(Policy policy) {
		
		return repo.save(policy); 
	}
	
	@Override
	public Policy updatePolicy(Policy policy, Integer id) {
	Policy policy2=repo.findByPolicyId(id);
	
	if(policy.getPolicyName()!=null) {
		policy2.setPolicyName(policy.getPolicyName());
	}
	if(policy.getCategory()!=null) {
		policy2.setCategory(policy.getCategory());
	}
	if(policy.getPremium()!=null) {
		policy2.setPremium(policy.getPremium());
	}
	if(policy.getTenure()!=null) {
		policy2.setTenure(policy.getTenure());
	}
	
		return repo.save(policy2);
		
	}

	@Override
	public Policy updateByPatch(Policy policy, Integer id) {
		Policy policy2=repo.findByPolicyId(id);
		
		if(policy.getPolicyName()!=null) {
			policy2.setPolicyName(policy.getPolicyName());
		}
		if(policy.getCategory()!=null) {
			policy2.setCategory(policy.getCategory());
		}
		if(policy.getPremium()!=null) {
			policy2.setPremium(policy.getPremium());
		}
		if(policy.getTenure()!=null) {
			policy2.setTenure(policy.getTenure());
		}
		
		return repo.save(policy2);
	}

	@Override
	public List<Policy> getAllPolicies(Integer pageNumber, Integer pageSize,String input, String dir) {
		
		log.info("Inside the getAllPolicies Method inside service");
		
		Sort sert= null;//(dir.equalsIgnoreCase("asc")?Sort.by(input).ascending():dir.equalsIgnoreCase("dsc")?Sort.by(input).descending());
		
		
		if(dir.equalsIgnoreCase("asc")) {
			sert=Sort.by(input).ascending();
		}
		else if(dir.equalsIgnoreCase("dsc")) {
			sert=Sort.by(input).descending();
		}
		
		
		Pageable p=PageRequest.of(pageNumber, pageSize,sert);
		Page<Policy> allPolicies=repo.findAll(p); //Pageable findAll method
		List<Policy> list=allPolicies.getContent();
		
		log.info("Returning the data from  getAllPolicies Method inside service");
		return list;
	}
	
	

}
