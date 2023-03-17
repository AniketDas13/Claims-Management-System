package com.cognizant.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ClaimsTest {

	Claims claim = new Claims();
	Claims claim1 = new Claims();

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
