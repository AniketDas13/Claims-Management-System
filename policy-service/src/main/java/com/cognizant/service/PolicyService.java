package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.ProviderPolicy;

@Service
public interface PolicyService {

	List<ProviderPolicy> getChainOfProviders(String policyId);

	List<String> getEligibleBenefits(String policyId, String memberId);

	List<String> getEligibleClaimAmount(String policyId, String memberId, String benefitId);

}
