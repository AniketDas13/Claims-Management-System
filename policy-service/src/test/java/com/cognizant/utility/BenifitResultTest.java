package com.cognizant.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class BenifitResultTest {
	BenifitResult benifitResult = new BenifitResult();
	BenifitResult benifitResult1 = new BenifitResult();

	@Test
	public void testgetBenifits() throws Exception {
		benifitResult.setBenifit("Family Coverage");
		assertEquals("Family Coverage", benifitResult.getBenifit());

	}

	@Test
	void testHashCode() {
		assertTrue(benifitResult.hashCode() == benifitResult.hashCode());
		assertTrue(benifitResult.hashCode() == benifitResult1.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(benifitResult.equals(benifitResult));
		assertTrue(benifitResult.equals(benifitResult1));
	}

	@Test
	void testCanEqual() {
		assertTrue(benifitResult.canEqual(benifitResult1));
	}

	@Test
	void testToString() {
		assertNotNull(benifitResult.toString());
	}

}
