package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.ProviderPolicy;
import com.cognizant.repository.PolicyProviderRepo;
import com.cognizant.repository.PolicyRepo;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepo policyRepo;

	@Autowired
	private PolicyProviderRepo policyProviderRepo;

	@Override
	public List<ProviderPolicy> getChainOfProviders(String policyId) {
		return policyProviderRepo.getChainOfProviders(policyId);
	}

	@Override
	public List<String> getEligibleBenefits(String policyId, String memberId) {
		return policyRepo.getEligibleBenefits(policyId, memberId);
	}

	@Override
	public List<String> getEligibleClaimAmount(String policyId, String memberId, String benefitId) {
		return policyRepo.getEligibleClaimAmount(policyId, memberId, benefitId);
	}

}
