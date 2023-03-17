package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ProviderPolicyTest {

	ProviderPolicy policy = new ProviderPolicy();
	ProviderPolicy policy1 = new ProviderPolicy();

	@Test
	public void testgetProviderId() throws Exception {
		policy.setProviderId(9001);
		assertEquals(9001, policy.getProviderId());
	}

	@Test
	public void testgetProviderName() throws Exception {
		policy.setProviderName("TATA");
		assertEquals("TATA", policy.getProviderName());
	}

	@Test
	public void testpgetPolicyId() throws Exception {
		policy.setPolicyId("1");
		assertEquals("1", policy.getPolicyId());
	}

	@Test
	public void testpgetPolicyName() throws Exception {
		policy.setPolicyName("Premium Gold");
		assertEquals("Premium Gold", policy.getPolicyName());
	}

	@Test
	public void testpgetHospitalId() throws Exception {
		policy.setHospitalId("H002");
		assertEquals("H002", policy.getHospitalId());
	}

	@Test
	public void testgetHospitalName() throws Exception {
		policy.setHospitalName("Tata Cancer Centre");
		assertEquals("Tata Cancer Centre", policy.getHospitalName());
	}

	@Test
	public void testgetLocation() throws Exception {
		policy.setLocation("Kolkata");
		assertEquals("Kolkata", policy.getLocation());
	}

	@Test
	public void testpgetBenifitId() throws Exception {
		policy.setBenefitId("B1");
		assertEquals("B1", policy.getBenefitId());
	}

	@Test
	public void testgetBenifits() throws Exception {
		policy.setBenefits("Family Coverage");
		assertEquals("Family Coverage", policy.getBenefits());
	}

	@Test
	public void testpgetPremiumAmount() throws Exception {
		policy.setPremiumAmt(5000);
		assertEquals(5000, policy.getPremiumAmt());
	}

	@Test
	public void testpgetTenure() throws Exception {
		policy.setTenure(2);
		assertEquals(2, policy.getTenure());
	}

	@Test
	public void testpgetClaimAmount() throws Exception {
		policy.setClaimAmt(500000);
		assertEquals(500000, policy.getClaimAmt());
	}

	@Test
	void testHashCode() {
		assertTrue(policy.hashCode() == policy.hashCode());
		assertTrue(policy.hashCode() == policy1.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(policy.equals(policy));
		assertTrue(policy.equals(policy1));
	}

	@Test
	void testCanEqual() {
		assertTrue(policy.canEqual(policy1));
	}

	@Test
	void testToString() {
		assertNotNull(policy.toString());
	}

}
