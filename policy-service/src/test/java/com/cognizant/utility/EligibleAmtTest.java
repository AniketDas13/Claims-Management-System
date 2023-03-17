package com.cognizant.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class EligibleAmtTest {

	EligibleAmt amt = new EligibleAmt();
	EligibleAmt amt1 = new EligibleAmt();

	@Test
	public void testgetEligibleAmt() throws Exception {
		amt.setAmount("50000");
		;
		assertEquals("50000", amt.getAmount());

	}

	@Test
	void testHashCode() {
		assertTrue(amt.hashCode() == amt.hashCode());
		assertTrue(amt.hashCode() == amt1.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(amt.equals(amt));
		assertTrue(amt.equals(amt1));
	}

	@Test
	void testCanEqual() {
		assertTrue(amt.canEqual(amt1));
	}

	@Test
	void testToString() {
		assertNotNull(amt.toString());
	}

}
