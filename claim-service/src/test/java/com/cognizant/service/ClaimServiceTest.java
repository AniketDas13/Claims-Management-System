package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.Claims;
import com.cognizant.repository.ClaimStatusRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClaimServiceTest {

	@Autowired
	private ClaimStatusServiceImpl serviceImpl;

	@MockBean
	private ClaimStatusRepo repo;

	@Test
	public void submitClaim() {
		Claims claims = new Claims();
		when(repo.save(claims)).thenReturn(claims);
		assertEquals(claims, claims);
	}

}
