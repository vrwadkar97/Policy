package com.policy.contoller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.policy.entity.Policy;
import com.policy.impl.Impl;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

@RestController
@RequestMapping("/policy")
public class Controller {
	
	org.slf4j.Logger log=LoggerFactory.getLogger(Controller.class);
	
	
	
	@Autowired
	private Impl impl;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPolicy(@RequestBody Policy policy){
		
		
		return new ResponseEntity<>(impl.addPolicy(policy), HttpStatus.CREATED);
	}
	
	@PutMapping("/put")
    public ResponseEntity<?> updatePolicy(@RequestBody Policy policy, @RequestParam(value="id") Integer id){
		
		return new ResponseEntity<>(impl.updatePolicy(policy,id), HttpStatus.OK);
	}
	
	@PatchMapping("/patch")
    public ResponseEntity<?> updateByPatch(@RequestParam(name="id") Policy policy,@RequestParam Integer id){
		return new ResponseEntity<>(impl.updateByPatch(policy, id), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllPolicy(
			@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber, 
			@RequestParam(value="pageSize",defaultValue="4",required=false) Integer pageSize,
			@RequestParam(value="sortBy", defaultValue = "policyId",required = false) String input,
			@RequestParam(value="dirn", defaultValue = "asc",required = false) String dir
			){
		
		log.info("inside the GetAllPolicy Method");
		List<Policy> list=impl.getAllPolicies(pageNumber, pageSize,input,dir);
		
		log.info("Returning the results");
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	
	

}
