package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long> {

	@Query(value = "select benefits from member_benefit m where m.policy_Id = :policyId and m.member_Id = :memberId", nativeQuery = true)
	public List<String> getEligibleBenefits(String policyId, String memberId);

	@Query(value = "select claim_Amt from member_benefit m where m.policy_Id = :policyId and m.member_Id = :memberId and m.benefit_Id = :benefitId", nativeQuery = true)
	public List<String> getEligibleClaimAmount(String policyId, String memberId, String benefitId);

}
