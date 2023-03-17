package com.cognizant.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class MemberpremiumTest {

	MemberPremium mem = new MemberPremium();
	MemberPremium mem1 = new MemberPremium();

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
