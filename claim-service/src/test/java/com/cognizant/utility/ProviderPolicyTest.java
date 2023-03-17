package com.cognizant.utility;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ProviderPolicyTest {

	ProviderPolicy policy = new ProviderPolicy();
	Policy policy1 = new Policy();

	@Test
	void testToString() {
		assertNotNull(policy.toString());
	}

}
