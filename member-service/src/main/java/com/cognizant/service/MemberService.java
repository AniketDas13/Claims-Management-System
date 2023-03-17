package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.MemberPolicy;

@Service
public interface MemberService {

	List<MemberPolicy> viewBills(String memberid, String policyId);

}
