package com.policy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="pol")
@Data
@Entity
public class Policy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer policyId;
	private String policyName;
	private String category;
	private Integer premium;
	private Integer tenure;

}
