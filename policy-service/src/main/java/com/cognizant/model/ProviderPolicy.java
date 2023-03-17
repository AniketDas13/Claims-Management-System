package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "provider_policy")
public class ProviderPolicy {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long providerId;

	@Column(name = "provider_Name")
	private String providerName;

	@Column(name = "policy_Id")
	private String policyId;

	@Column(name = "policy_Name")
	private String policyName;

	@Column(name = "hospital_Id")
	private String hospitalId;

	@Column(name = "hospital_Name")
	private String hospitalName;

	@Column(name = "location")
	private String location;

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
