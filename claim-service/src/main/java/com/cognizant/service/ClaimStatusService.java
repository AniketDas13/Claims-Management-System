package com.cognizant.service;

import org.springframework.stereotype.Service;

import com.cognizant.model.Claims;

@Service
public interface ClaimStatusService {

	Claims submitClaimStatus(Claims claim);

	String getClaimStatus(String claimId, String policyId, String memberId);

}
