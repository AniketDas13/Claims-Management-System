package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.ProviderPolicy;
import com.cognizant.service.PolicyService;
import com.cognizant.utility.ProviderResult;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	/*
	 * @Autowired private PolicyProviderRepo repo;
	 */

	@GetMapping("/getChainOfProviders/{policyId}")
	public List<ProviderResult> getChainOfProviders(@PathVariable("policyId") String policyId) {

		List<ProviderPolicy> providerPolicy = policyService.getChainOfProviders(policyId);
		List<ProviderResult> providerResult = new ArrayList<>();
		for (ProviderPolicy policy : providerPolicy) {
			providerResult.add(new ProviderResult(policy.getProviderName(), policy.getLocation()));
		}
		return providerResult;
	}

	@GetMapping("/getEligibleBenefits/{policyId}/{memberId}")
	public List<String> getEligibleBenefits(@PathVariable("policyId") String policyId,
			@PathVariable("memberId") String memberId) {
		return policyService.getEligibleBenefits(policyId, memberId);
	}

	@GetMapping("/getEligibleClaimAmount/{policyId}/{memberId}/{benefitId}")
	public List<String> getEligibleClaimAmount(@PathVariable("policyId") String policyId,
			@PathVariable("memberId") String memberId, @PathVariable("benefitId") String benefitId) {
		return policyService.getEligibleClaimAmount(policyId, memberId, benefitId);
	}

	/*
	 * @GetMapping("/viewAll") public List<ProviderPolicy> viewAll() { return
	 * repo.findAll(); }
	 */

}
