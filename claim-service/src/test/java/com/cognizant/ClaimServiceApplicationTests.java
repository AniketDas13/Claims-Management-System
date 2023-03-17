package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.model.Claims;
import com.cognizant.repository.ClaimStatusRepo;
import com.cognizant.service.ClaimStatusService;
import com.cognizant.utility.Policy;
import com.cognizant.utility.ProviderPolicy;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
class ClaimServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClaimStatusRepo repo;

	@MockBean
	private ClaimStatusService service;

	Gson gson = new Gson();

	@Test
	@DisplayName("Given Claim data should save the data to DB and return Claim data")
	public void testsubmitClaimStatus() throws Exception {
		Claims claim = new Claims();
		claim.setClaimId(2);
		claim.setClaimStatus("Pending Action");
		claim.setMemberId("101");
		claim.setPolicyId("1");
		claim.setHospitalId("H002");
		claim.setBenefitId("B1");
		claim.setTotalBill(10000);
		claim.setClaimedAmount(5000);
		when(repo.save(Mockito.any())).thenReturn(claim);
		mockMvc.perform(MockMvcRequestBuilders.post("/submitClaim").contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(claim))).andExpect(status().isOk());
	}

	@Test
	@DisplayName("to view the Claim status based on claim_id,policy_id,member_id")
	public void testGetClaimStatus() throws Exception {
		Claims claim = new Claims();
		claim.setClaimId(1);
		claim.setPolicyId("1");
		claim.setMemberId("101");
		mockMvc.perform(MockMvcRequestBuilders.get("/getClaimStatus/1/1/101").contentType(MediaType.APPLICATION_JSON));
	}

	/* testing for getters setters and constuctors */
	@Test
	@DisplayName("to test the claim id")
	public void testClaimId() throws Exception {
		Claims claim = new Claims();
		claim.setClaimId(2);
		assertTrue(claim.getClaimId() == 2);
	}

	@Test
	@DisplayName("to test the claim status")
	public void testClaimStatus() throws Exception {
		Claims claim = new Claims();
		claim.setClaimStatus("Claim Rejected");
		assertTrue(claim.getClaimStatus() == "Claim Rejected");
	}

	@Test
	@DisplayName("to test the member id")
	public void testMemberId() throws Exception {
		Claims claim = new Claims();
		claim.setMemberId("101");
		assertTrue(claim.getMemberId() == "101");
	}

	@Test
	@DisplayName("to test the policy id")
	public void testPolcyId() throws Exception {
		Claims claim = new Claims();
		claim.setPolicyId("1");
		assertTrue(claim.getPolicyId() == "1");
	}

	@Test
	@DisplayName("to test the hospital id")
	public void testHospitalId() throws Exception {
		Claims claim = new Claims();
		claim.setHospitalId("H001");
		assertTrue(claim.getHospitalId() == "H001");
	}

	@Test
	@DisplayName("to test the benifit id")
	public void testBenefitId() throws Exception {
		Claims claim = new Claims();
		claim.setBenefitId("B1");
		assertTrue(claim.getBenefitId() == "B1");
	}

	@Test
	@DisplayName("to test the total bill")
	public void testTotalBill() throws Exception {
		Claims claim = new Claims();
		claim.setTotalBill(10000);
		assertTrue(claim.getTotalBill() == 10000);
	}

	@Test
	@DisplayName("to test the claim amount")
	public void testClaimedAmount() throws Exception {
		Claims claim = new Claims();
		claim.setClaimedAmount(5000);
		assertTrue(claim.getClaimedAmount() == 5000);
	}

	@Test
	public void testgetClaimId() throws Exception {
		Claims claim = new Claims();
		claim.setClaimId(2);
		assertEquals(2, claim.getClaimId());
	}

	@Test
	public void testgetClaimStatus() throws Exception {
		Claims claim = new Claims();
		claim.setClaimStatus("Claim Rejected");
		assertEquals("Claim Rejected", claim.getClaimStatus());
	}

	@Test
	public void testgetMemberId() throws Exception {
		Claims claim = new Claims();
		claim.setMemberId("101");
		assertEquals("101", claim.getMemberId());
	}

	@Test
	public void testgetPolcyId() throws Exception {
		Claims claim = new Claims();
		claim.setPolicyId("1");
		assertEquals("1", claim.getPolicyId());
	}

	@Test
	public void testgetHospitalId() throws Exception {
		Claims claim = new Claims();
		claim.setHospitalId("H001");
		assertEquals("H001", claim.getHospitalId());
	}

	@Test
	public void testgetBenefitId() throws Exception {
		Claims claim = new Claims();
		claim.setBenefitId("B1");
		assertEquals("B1", claim.getBenefitId());
	}

	@Test
	public void testgetTotalBill() throws Exception {
		Claims claim = new Claims();
		claim.setTotalBill(10000);
		assertEquals(10000, claim.getTotalBill());
	}

	@Test
	@DisplayName("to test the claim amount")
	public void testgetClaimedAmount() throws Exception {
		Claims claim = new Claims();
		claim.setClaimedAmount(5000);
		assertEquals(5000, claim.getClaimedAmount());
	}

	@Test
	@DisplayName("to test the claims constructor in claims table")
	public void testClaimConstructor() throws Exception {
		Claims claim = new Claims();
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

}
