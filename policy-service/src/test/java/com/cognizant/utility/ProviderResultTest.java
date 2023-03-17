package com.cognizant.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ProviderResultTest {

	ProviderResult result = new ProviderResult();
	ProviderResult result1 = new ProviderResult();

	@Test
	public void testgetProviderName() throws Exception {
		result.setProviderName("TATA");
		assertEquals("TATA", result.getProviderName());

	}

	@Test
	public void testgetProviderLocation() throws Exception {
		result.setProviderLocation("Kolkata");
		assertEquals("Kolkata", result.getProviderLocation());

	}

	@Test
	void testHashCode() {
		assertTrue(result.hashCode() == result.hashCode());
		assertTrue(result.hashCode() == result1.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(result.equals(result));
		assertTrue(result.equals(result1));
	}

	@Test
	void testCanEqual() {
		assertTrue(result.canEqual(result1));
	}

	@Test
	void testToString() {
		assertNotNull(result.toString());
	}

}
