package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Claims;
import com.cognizant.repository.ClaimStatusRepo;
import com.cognizant.repository.PolicyProviderRepo;
import com.cognizant.repository.PolicyRepo;
import com.cognizant.utility.Policy;
import com.cognizant.utility.ProviderPolicy;

@Service
public class ClaimStatusServiceImpl implements ClaimStatusService {

	@Autowired
	private ClaimStatusRepo claimStatusRepo;

	@Autowired
	private PolicyRepo policyRepo;

	@Autowired
	private PolicyProviderRepo policyProviderRepo;

	@Override
	public Claims submitClaimStatus(Claims claim) {

		Policy policy = policyRepo.getById(Long.parseLong(claim.getPolicyId()));

		List<ProviderPolicy> policyProvider = policyProviderRepo.findByPolicyId(claim.getPolicyId());

		if (claim.getClaimedAmount() <= policy.getClaimAmt() && claim.getBenefitId().equals(policy.getBenefitId())) {
			for (ProviderPolicy pp : policyProvider) {
				if (claim.getHospitalId().equals(pp.getHospitalId())) {
					claim.setClaimStatus("Pending Action");
					return claimStatusRepo.save(claim);
				}
			}
		}

		claim.setClaimStatus("Claim Rejected");
		return claimStatusRepo.save(claim);
	}

	@Override
	public String getClaimStatus(String claimId, String policyId, String memberId) {
		return claimStatusRepo.getClaimStatus(claimId, policyId, memberId);
	}

}
