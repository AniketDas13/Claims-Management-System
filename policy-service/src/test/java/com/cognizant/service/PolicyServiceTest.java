package com.cognizant.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.ProviderPolicy;
import com.cognizant.repository.PolicyProviderRepo;
import com.cognizant.repository.PolicyRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class PolicyServiceTest {

	@Autowired
	private PolicyServiceImpl service;

	@MockBean
	private PolicyProviderRepo repo;

	@MockBean
	private PolicyRepo repopolicy;

	@Test
	public void getChainOfProviders() throws Exception {
		String policyId = "2";
		when(repo.getChainOfProviders(policyId))
				.thenReturn(Stream.of(new ProviderPolicy()).collect(Collectors.toList()));
		assertEquals(1, service.getChainOfProviders(policyId).size());
	}

}
