package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.model.Claims;

public interface ClaimStatusRepo extends JpaRepository<Claims, Long> {

	@Query(value = "select claim_Status from claims c where c.claim_Id = :claimId and c.policy_Id = :policyId and c.member_Id = :memberId", nativeQuery = true)
	String getClaimStatus(String claimId, String policyId, String memberId);

}
