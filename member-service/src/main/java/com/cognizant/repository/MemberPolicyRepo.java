package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.model.MemberPolicy;

@Repository
public interface MemberPolicyRepo extends JpaRepository<MemberPolicy, Long> {

	@Query(value = "select * from member_policy mp where mp.member_id = :memberId and mp.policy_Id = :policyId", nativeQuery = true)
	public List<MemberPolicy> viewBills(String memberId, String policyId);

}
