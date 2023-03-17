package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "claims")
public class Claims {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long claimId;

	@Column(name = "claim_Status")
	private String claimStatus;

	@Column(name = "member_Id")
	private String memberId;

	@Column(name = "policy_Id")
	private String policyId;

	@Column(name = "hospital_Id")
	private String hospitalId;

	@Column(name = "benefit_Id")
	private String benefitId;

	@Column(name = "total_Bill")
	private long totalBill;

	@Column(name = "claimed_Amt")
	private long claimedAmount;
}
