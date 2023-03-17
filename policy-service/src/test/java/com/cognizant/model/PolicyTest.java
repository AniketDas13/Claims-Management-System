package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class PolicyTest {

	Policy policy = new Policy();
	Policy policy1 = new Policy();

	@Test
	public void testgetPolicyId() throws Exception {
		policy.setPolicyId(1);
		assertEquals(1, policy.getPolicyId());
	}

	@Test
	public void testgetPolicyName() throws Exception {
		policy.setPolicyName("Premium Gold");
		assertEquals("Premium Gold", policy.getPolicyName());
	}

	@Test
	public void testgetBenifitId() throws Exception {
		policy.setBenefitId("B1");
		assertEquals("B1", policy.getBenefitId());
	}

	@Test
	public void testgetBenifis() throws Exception {
		policy.setBenefits("Family Coverage");
		assertEquals("Family Coverage", policy.getBenefits());
	}

	@Test
	public void testgetPremiumAmount() throws Exception {
		policy.setPremiumAmt(5000);
		assertEquals(5000, policy.getPremiumAmt());
	}

	@Test
	public void testgetTenure() throws Exception {
		policy.setTenure(2);
		assertEquals(2, policy.getTenure());
	}

	@Test
	public void testgetClaimAmount() throws Exception {
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
