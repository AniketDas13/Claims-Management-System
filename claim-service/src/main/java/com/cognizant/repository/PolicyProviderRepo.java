package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.utility.ProviderPolicy;

@Repository
public interface PolicyProviderRepo extends JpaRepository<ProviderPolicy, Long> {

	@Query(value = "select * from provider_policy pp where pp.policy_id = :policyId", nativeQuery = true)
	public List<ProviderPolicy> findByPolicyId(String policyId);
}
