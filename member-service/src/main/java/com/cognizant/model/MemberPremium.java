package com.cognizant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "member_premium")
public class MemberPremium {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberPremiumId;

	@Column(name = "member_Id")
	private String memberId;

	@Column(name = "policy_Id")
	private String policyId;

	@Column(name = "lastPremium_Date")
	private Date lastPremiumDate;

	@Column(name = "premium_AmtDue")
	private long premiumAmtDue;
}
