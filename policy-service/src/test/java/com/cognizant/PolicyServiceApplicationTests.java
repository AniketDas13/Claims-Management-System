package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.model.MemberPolicy;
import com.cognizant.model.Policy;
import com.cognizant.model.ProviderPolicy;
import com.cognizant.repository.PolicyProviderRepo;
import com.cognizant.service.PolicyService;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
class PolicyServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PolicyProviderRepo repo;

	@MockBean
	private PolicyService service;

	Gson gson = new Gson();

	@Test
	public void testgetChainOfProviders() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPolicyId("1");
		// when(service.getChainOfProviders(Mockito.anyString()).thenReturn(providerName,Location));
		mockMvc.perform(MockMvcRequestBuilders.get("/getChainOfProviders/1").contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void getEligibleBenefits() throws Exception {
		Policy policy = new Policy();
		MemberPolicy member = new MemberPolicy();
		policy.setPolicyId(1);
		member.setMemberId("101");
		// when(service.getEligibleBenefits(Mockito.anyInt(),Mockito.anyString())).thenReturn(beni);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getEligibleBenefits/1/101").contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void getEligibleClaimAmount() throws Exception {
		Policy policy = new Policy();
		MemberPolicy member = new MemberPolicy();
		policy.setPolicyId(1);
		member.setMemberId("101");
		policy.setBenefitId("B1");
		// when(service.getEligibleBenefits(Mockito.anyInt(),Mockito.anyString())).thenReturn(beni);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getEligibleClaimAmount/1/101/B1").contentType(MediaType.APPLICATION_JSON));
	}

	/* testing for getters setters and constuctors */
	@Test
	@DisplayName("to test the member policy id")
	public void testClaimId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberPolicyId(1011);
		assertTrue(mem.getMemberPolicyId() == 1011);
	}

	@Test
	@DisplayName("to test the member id")
	public void testMemberId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberId("101");
		assertTrue(mem.getMemberId() == "101");
	}

	@Test
	@DisplayName("to test the policy id")
	public void testPolcyId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPolicyId("1");
		assertTrue(mem.getPolicyId() == "1");
	}

	@Test
	@DisplayName("to test the premium amount due")
	public void testPremiumAMountDue() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPremiumAmtDue(1000);
		assertTrue(mem.getPremiumAmtDue() == 1000);
	}

	@Test
	@DisplayName("to test is late")
	public void testIsLate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLate(false);
		assertTrue(mem.isLate() == false);
	}

	@Test
	@DisplayName("to test the member policy id")
	public void testgetClaimId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberPolicyId(1011);
		assertEquals(1011, mem.getMemberPolicyId());
	}

	@Test
	@DisplayName("to test the member id")
	public void testgetMemberId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberId("101");
		assertEquals("101", mem.getMemberId());
	}

	@Test
	@DisplayName("to test the policy id")
	public void testgetPolcyId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPolicyId("1");
		assertEquals("1", mem.getPolicyId());
	}

	@Test
	@DisplayName("to test the subscription date")
	public void testgetSubscriptionDate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setSubscriptionDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-01"), mem.getSubscriptionDate());
	}

	@Test
	@DisplayName("to test the last premium date")
	public void testgetLastPremiumDate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLastPremiumDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"), mem.getLastPremiumDate());
	}

	@Test
	@DisplayName("to test the premium amount due")
	public void testgetPremiumAMountDue() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPremiumAmtDue(1000);
		assertEquals(1000, mem.getPremiumAmtDue());
	}

	@Test
	@DisplayName("to test is late")
	public void testgetIsLate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLate(false);
		assertEquals(false, mem.isLate());
	}

	@Test
	@DisplayName("to test the due date")
	public void testgetDueDate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-01"), mem.getDueDate());
	}

	@Test
	@DisplayName("to test the member policy constructor in member policy table")
	public void testClaimConstructor() throws Exception {
		MemberPolicy member = new MemberPolicy();
	}

	/* testing for getters setters and constuctors for Policy Class */

	@Test
	@DisplayName("to test the policy id")
	public void testPolicyId() throws Exception {
		Policy policy = new Policy();
		policy.setPolicyId(1);
		assertTrue(policy.getPolicyId() == 1);
	}

	@Test
	@DisplayName("to test the policy name")
	public void testPolicyName() throws Exception {
		Policy policy = new Policy();
		policy.setPolicyName("Premium Gold");
		assertTrue(policy.getPolicyName() == "Premium Gold");
	}

	@Test
	@DisplayName("to test the benifit id")
	public void testBenifitId() throws Exception {
		Policy policy = new Policy();
		policy.setBenefitId("B1");
		assertTrue(policy.getBenefitId() == "B1");
	}

	@Test
	@DisplayName("to test the benefits")
	public void testBenifis() throws Exception {
		Policy policy = new Policy();
		policy.setBenefits("Family Coverage");
		assertTrue(policy.getBenefits() == "Family Coverage");
	}

	@Test
	@DisplayName("to test the premium amount")
	public void testPremiumAmount() throws Exception {
		Policy policy = new Policy();
		policy.setPremiumAmt(5000);
		assertTrue(policy.getPremiumAmt() == 5000);
	}

	@Test
	@DisplayName("to test the tenure")
	public void testTenure() throws Exception {
		Policy policy = new Policy();
		policy.setTenure(2);
		assertTrue(policy.getTenure() == 2);
	}

	@Test
	@DisplayName("to test the cliamed amount")
	public void testClaimAmount() throws Exception {
		Policy policy = new Policy();
		policy.setClaimAmt(500000);
		assertTrue(policy.getClaimAmt() == 500000);
	}

	@Test
	@DisplayName("to test the policy id")
	public void testgetPolicyId() throws Exception {
		Policy policy = new Policy();
		policy.setPolicyId(1);
		assertEquals(1, policy.getPolicyId());
	}

	@Test
	@DisplayName("to test the policy name")
	public void testgetPolicyName() throws Exception {
		Policy policy = new Policy();
		policy.setPolicyName("Premium Gold");
		assertEquals("Premium Gold", policy.getPolicyName());
	}

	@Test
	@DisplayName("to test the benifit id")
	public void testgetBenifitId() throws Exception {
		Policy policy = new Policy();
		policy.setBenefitId("B1");
		assertEquals("B1", policy.getBenefitId());
	}

	@Test
	@DisplayName("to test the benefits")
	public void testgetBenifis() throws Exception {
		Policy policy = new Policy();
		policy.setBenefits("Family Coverage");
		assertEquals("Family Coverage", policy.getBenefits());
	}

	@Test
	@DisplayName("to test the premium amount")
	public void testgetPremiumAmount() throws Exception {
		Policy policy = new Policy();
		policy.setPremiumAmt(5000);
		assertEquals(5000, policy.getPremiumAmt());
	}

	@Test
	@DisplayName("to test the tenure")
	public void testgetTenure() throws Exception {
		Policy policy = new Policy();
		policy.setTenure(2);
		assertEquals(2, policy.getTenure());
	}

	@Test
	@DisplayName("to test the cliamed amount")
	public void testgetClaimAmount() throws Exception {
		Policy policy = new Policy();
		policy.setClaimAmt(500000);
		assertEquals(500000, policy.getClaimAmt());
	}

	@Test
	@DisplayName("to test the policy constructor in policy table")
	public void testPolicyConstructor() throws Exception {
		Policy policy = new Policy();
	}

	/* testing for getters setters and constuctors for Provider Policy Class */

	@Test
	@DisplayName("to test the provider id")
	public void testProviderId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setProviderId(9001);
		assertTrue(pp.getProviderId() == 9001);
	}

	@Test
	@DisplayName("to test the provider name")
	public void testProviderName() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setProviderName("TATA");
		assertTrue(pp.getProviderName() == "TATA");
	}

	@Test
	@DisplayName("to test the policy id")
	public void testpPolicyId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPolicyId("1");
		assertTrue(pp.getPolicyId() == "1");
	}

	@Test
	@DisplayName("to test the policy name")
	public void testpPolicyName() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPolicyName("Premium Gold");
		assertTrue(pp.getPolicyName() == "Premium Gold");
	}

	@Test
	@DisplayName("to test the hospital id")
	public void testpHospitalId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setHospitalId("H002");
		assertTrue(pp.getHospitalId() == "H002");
	}

	@Test
	@DisplayName("to test the hospital name")
	public void testHospitalName() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setHospitalName("Tata Cancer Centre");
		assertTrue(pp.getHospitalName() == "Tata Cancer Centre");
	}

	@Test
	@DisplayName("to test the hospital Location")
	public void testLocation() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setLocation("Kolkata");
		assertTrue(pp.getLocation() == "Kolkata");
	}

	@Test
	@DisplayName("to test the benifit id")
	public void testpBenifitId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setBenefitId("B1");
		assertTrue(pp.getBenefitId() == "B1");
	}

	@Test
	@DisplayName("to test the benefits")
	public void testBenifits() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setBenefits("Family Coverage");
		assertTrue(pp.getBenefits() == "Family Coverage");
	}

	@Test
	@DisplayName("to test the premium amount")
	public void testpPremiumAmount() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPremiumAmt(5000);
		assertTrue(pp.getPremiumAmt() == 5000);
	}

	@Test
	@DisplayName("to test the tenure")
	public void testpTenure() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setTenure(2);
		assertTrue(pp.getTenure() == 2);
	}

	@Test
	@DisplayName("to test the cliamed amount")
	public void testpClaimAmount() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setClaimAmt(500000);
		assertTrue(pp.getClaimAmt() == 500000);
	}

	@Test
	@DisplayName("to test the provider id")
	public void testgetProviderId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setProviderId(9001);
		assertEquals(9001, pp.getProviderId());
	}

	@Test
	@DisplayName("to test the provider name")
	public void testgetProviderName() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setProviderName("TATA");
		assertEquals("TATA", pp.getProviderName());
	}

	@Test
	@DisplayName("to test the policy id")
	public void testpgetPolicyId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPolicyId("1");
		assertEquals("1", pp.getPolicyId());
	}

	@Test
	@DisplayName("to test the policy name")
	public void testpgetPolicyName() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPolicyName("Premium Gold");
		assertEquals("Premium Gold", pp.getPolicyName());
	}

	@Test
	@DisplayName("to test the hospital id")
	public void testpgetHospitalId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setHospitalId("H002");
		assertEquals("H002", pp.getHospitalId());
	}

	@Test
	@DisplayName("to test the hospital name")
	public void testgetHospitalName() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setHospitalName("Tata Cancer Centre");
		assertEquals("Tata Cancer Centre", pp.getHospitalName());
	}

	@Test
	@DisplayName("to test the hospital Location")
	public void testgetLocation() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setLocation("Kolkata");
		assertEquals("Kolkata", pp.getLocation());
	}

	@Test
	@DisplayName("to test the benifit id")
	public void testpgetBenifitId() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setBenefitId("B1");
		assertEquals("B1", pp.getBenefitId());
	}

	@Test
	@DisplayName("to test the benefits")
	public void testgetBenifits() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setBenefits("Family Coverage");
		assertEquals("Family Coverage", pp.getBenefits());
	}

	@Test
	@DisplayName("to test the premium amount")
	public void testpgetPremiumAmount() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setPremiumAmt(5000);
		assertEquals(5000, pp.getPremiumAmt());
	}

	@Test
	@DisplayName("to test the tenure")
	public void testpgetTenure() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setTenure(2);
		assertEquals(2, pp.getTenure());
	}

	@Test
	@DisplayName("to test the cliamed amount")
	public void testpgetClaimAmount() throws Exception {
		ProviderPolicy pp = new ProviderPolicy();
		pp.setClaimAmt(500000);
		assertEquals(500000, pp.getClaimAmt());
	}

	@Test
	@DisplayName("to test the policy provider constructor in policy provider table")
	public void testProviderPolicyConstructor() throws Exception {
		ProviderPolicy policy = new ProviderPolicy();
	}

	@Test
	public void main() {
		PolicyServiceApplication.main(new String[] {});
	}

}
