package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ClaimsTest {

	Claims claim = new Claims();
	Claims claim1 = new Claims();

	@Test
	public void testGetClaimId() {
		claim.setClaimId(1);
		assertEquals(1, claim.getClaimId());
	}

	@Test
	void testGetClaimStatus() {
		claim.setClaimStatus("Claim Pending");
		assertEquals("Claim Pending", claim.getClaimStatus());
	}

	@Test
	void testGetpolicyId() {
		claim.setPolicyId("1");
		assertEquals("1", claim.getPolicyId());
	}

	@Test
	void testGetMemberId() {
		claim.setMemberId("121");
		assertEquals("121", claim.getMemberId());
	}

	@Test
	void testGetHospitalId() {
		claim.setHospitalId("H001");
		assertEquals("H001", claim.getHospitalId());
	}

	@Test
	void testGetBenefitId() {
		claim.setBenefitId("B1");
		assertEquals("B1", claim.getBenefitId());
	}

	@Test
	void testGetTotalBill() {
		claim.setTotalBill(10000);
		assertEquals(10000, claim.getTotalBill());
	}

	@Test
	void testGetClaimedAmount() {
		claim.setClaimedAmount(5000);
		assertEquals(5000, claim.getClaimedAmount());
	}

	@Test
	void testHashCode() {
		assertTrue(claim.hashCode() == claim.hashCode());
		assertTrue(claim.hashCode() == claim1.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(claim.equals(claim));
		assertTrue(claim.equals(claim1));
	}

	@Test
	void testCanEqual() {
		assertTrue(claim.canEqual(claim));
	}

	@Test
	void testToString() {
		assertNotNull(claim.toString());
	}

}
