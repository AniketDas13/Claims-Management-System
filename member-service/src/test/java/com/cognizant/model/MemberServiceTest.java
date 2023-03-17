package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.repository.MemberPolicyRepo;
import com.cognizant.service.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberServiceTest {

	@Autowired
	private MemberServiceImpl service;

	@MockBean
	private MemberPolicyRepo repo;

	@Test
	public void viewBillsTest() {
		String memberId = "101";
		String policyId = "1";
		when(repo.viewBills(memberId, policyId)).thenReturn(Stream.of(new MemberPolicy()).collect(Collectors.toList()));
		assertEquals(1, service.viewBills(memberId, policyId).size());
	}

}
