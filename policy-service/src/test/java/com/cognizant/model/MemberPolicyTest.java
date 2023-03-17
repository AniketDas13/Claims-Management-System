package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

class MemberPolicyTest {

	MemberPolicy mem = new MemberPolicy();
	MemberPolicy mem1 = new MemberPolicy();

	@Test
	public void testgetMemberPolicyId() throws Exception {
		mem.setMemberPolicyId(1011);
		assertEquals(1011, mem.getMemberPolicyId());
	}

	@Test
	public void testgetMemberId() throws Exception {
		mem.setMemberId("101");
		assertEquals("101", mem.getMemberId());
	}

	@Test
	public void testgetPolcyId() throws Exception {
		mem.setPolicyId("1");
		assertEquals("1", mem.getPolicyId());
	}

	@Test
	public void testgetSubscriptionDate() throws Exception {
		mem.setSubscriptionDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-01"), mem.getSubscriptionDate());
	}

	@Test
	public void testgetLastPremiumDate() throws Exception {
		mem.setLastPremiumDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"), mem.getLastPremiumDate());
	}

	@Test
	public void testgetPremiumAMountDue() throws Exception {
		mem.setPremiumAmtDue(1000);
		assertEquals(1000, mem.getPremiumAmtDue());
	}

	@Test
	public void testgetIsLate() throws Exception {
		mem.setLate(false);
		assertEquals(false, mem.isLate());
	}

	@Test
	public void testgetDueDate() throws Exception {
		mem.setDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-01"), mem.getDueDate());
	}

	@Test
	void testHashCode() {
		assertTrue(mem.hashCode() == mem.hashCode());
		assertTrue(mem.hashCode() == mem1.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(mem.equals(mem));
		assertTrue(mem.equals(mem1));
	}

	@Test
	void testCanEqual() {
		assertTrue(mem.canEqual(mem1));
	}

	@Test
	void testToString() {
		assertNotNull(mem.toString());
	}

}
