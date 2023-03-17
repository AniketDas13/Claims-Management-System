package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.MemberPolicy;
import com.cognizant.repository.MemberPolicyRepo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberPolicyRepo memberPolicyRepo;

	@Override
	public List<MemberPolicy> viewBills(String memberId, String policyId) {
		return memberPolicyRepo.viewBills(memberId, policyId);
	}

}
