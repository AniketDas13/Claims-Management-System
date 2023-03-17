package com.cognizant.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "policy")
public class Policy {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long policyId;

	@Column(name = "policy_Name")
	private String policyName;

	@Column(name = "benefit_Id")
	private String benefitId;

	@Column(name = "benefits")
	private String benefits;

	@Column(name = "premium_Amt")
	private long premiumAmt;

	@Column(name = "tenure")
	private long tenure;

	@Column(name = "claim_Amt")
	private long claimAmt;
}
