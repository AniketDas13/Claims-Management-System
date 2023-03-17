package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.model.Claims;
import com.cognizant.model.MemberPolicy;
import com.cognizant.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	private MemberService memberService;

	/*
	 * @Autowired private MemberPolicyRepo repo;
	 */

	@GetMapping("/viewBills/{memberId}/{policyId}")
	public List<MemberPolicy> viewBills(@PathVariable("memberId") String memberId,
			@PathVariable("policyId") String policyId) {
		return memberService.viewBills(memberId, policyId);
	}

	@PostMapping("/submitClaim")
	public Claims submitClaimStatus(@RequestBody Claims claim) {
		return restTemp.postForObject("http://claimservice/submitClaim", claim, Claims.class);
	}

	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public String getClaimStatus(@PathVariable("claimId") String claimId, @PathVariable("policyId") String policyId,
			@PathVariable("memberId") String memberId) {
		return restTemp.getForObject("http://claimservice/getClaimStatus/" + claimId + "/" + policyId + "/" + memberId,
				String.class);
	}

	/*
	 * @GetMapping("/viewAll") public List<MemberPolicy> viewAll() { return
	 * repo.findAll(); }
	 */

}
