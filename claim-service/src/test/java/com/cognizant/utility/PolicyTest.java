package com.cognizant.utility;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyTest {

	Policy policy = new Policy();
	Policy policy1 = new Policy();

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
