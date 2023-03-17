package com.cognizant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "member_policy")
public class MemberPolicy {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberPolicyId;

	@Column(name = "member_Id")
	private String memberId;

	@Column(name = "policy_Id")
	private String policyId;

	@Column(name = "subscription_Date")
	private Date subscriptionDate;

	@Column(name = "lastPremium_Date")
	private Date lastPremiumDate;

	@Column(name = "premium_AmtDue")
	private long premiumAmtDue;

	@Column(name = "is_Late")
	private boolean isLate;

	@Column(name = "due_Date")
	private Date dueDate;
}
