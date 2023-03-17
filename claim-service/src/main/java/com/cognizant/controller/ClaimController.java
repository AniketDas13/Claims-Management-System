package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Claims;
import com.cognizant.service.ClaimStatusService;

@RestController
public class ClaimController {

	@Autowired
	private ClaimStatusService claimStatusService;

	/*
	 * @Autowired private ClaimStatusRepo repo;
	 */

	@PostMapping("/submitClaim")
	public Claims submitClaimStatus(@RequestBody Claims claim) {
		return claimStatusService.submitClaimStatus(claim);
	}

	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public String getClaimStatus(@PathVariable("claimId") String claimId, @PathVariable("policyId") String policyId,
			@PathVariable("memberId") String memberId) {
		return claimStatusService.getClaimStatus(claimId, policyId, memberId);
	}
	/*
	 * @GetMapping("/viewAll") public List<Claims> viewAll() { return
	 * repo.findAll(); }
	 */

}
