package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import com.cognizant.model.MemberPolicy;
import com.cognizant.model.MemberPremium;
import com.cognizant.model.Members;
import com.cognizant.repository.MemberPolicyRepo;
import com.cognizant.service.MemberService;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
class MemberServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MemberPolicyRepo repo;

	@MockBean
	private MemberService service;

	Gson gson = new Gson();

	@Test
	public void testViewBills() throws Exception {
		List<MemberPolicy> memList = new ArrayList<>();
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberId("101");
		mem.setPolicyId("1");
		when(service.viewBills(Mockito.anyString(), Mockito.anyString())).thenReturn(memList);
		mockMvc.perform(MockMvcRequestBuilders.get("/viewBills/101/1").contentType(MediaType.APPLICATION_JSON));
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

	/* testing for getters setters and constuctors */

	@Test
	public void testMemberPolicyId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberPolicyId(1011);
		assertTrue(mem.getMemberPolicyId() == 1011);
	}

	@Test
	public void testMembersId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberId("101");
		assertTrue(mem.getMemberId() == "101");
	}

	@Test
	public void testPolicyId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPolicyId("1");
		assertTrue(mem.getPolicyId() == "1");
	}

	@Test
	public void testPremiumAMountDue() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPremiumAmtDue(1000);
		assertTrue(mem.getPremiumAmtDue() == 1000);
	}

	@Test
	public void testIsLate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLate(false);
		assertTrue(mem.isLate() == false);
	}

	@Test
	public void testgetMemberPolcyId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberPolicyId(1011);
		assertEquals(1011, mem.getMemberPolicyId());
	}

	@Test
	public void testgetMembersId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setMemberId("101");
		assertEquals("101", mem.getMemberId());
	}

	@Test
	public void testgetPolicyId() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPolicyId("1");
		assertEquals("1", mem.getPolicyId());
	}

	@Test
	public void testgetSubscriptionDate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setSubscriptionDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-01"), mem.getSubscriptionDate());
	}

	@Test
	public void testgetLastPremiumDate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLastPremiumDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"), mem.getLastPremiumDate());
	}

	@Test
	public void testgetPremiumAMountDue() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPremiumAmtDue(1000);
		assertEquals(1000, mem.getPremiumAmtDue());
	}

	@Test
	public void testgetIsLate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLate(false);
		assertEquals(false, mem.isLate());
	}

	@Test
	public void testgetDueDate() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-01"), mem.getDueDate());
	}

	@Test
	@DisplayName("to test the MemberPolicy constructor")
	public void testMemberPolicyConstructor() throws Exception {
		MemberPolicy mem = new MemberPolicy();
	}

	/* testing for getters setters and constuctors */

	@Test
	public void testMemberPremiumId() throws Exception {
		MemberPremium mem = new MemberPremium();
		mem.setMemberPremiumId(1011);
		assertTrue(mem.getMemberPremiumId() == 1011);
	}

	@Test
	public void testPolciy_Id() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPolicyId("1");
		assertTrue(mem.getPolicyId() == "1");
	}

	@Test
	public void testPremiumAmountDue() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPremiumAmtDue(1000);
		assertTrue(mem.getPremiumAmtDue() == 1000);
	}

	@Test
	public void testgetMemberPremiumId() throws Exception {
		MemberPremium mem = new MemberPremium();
		mem.setMemberPremiumId(1011);
		assertEquals(1011, mem.getMemberPremiumId());
	}

	@Test
	public void testgetPolciy_Id() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPolicyId("1");
		assertEquals("1", mem.getPolicyId());
	}

	@Test
	public void testgetLastPremium_Date() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setLastPremiumDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"), mem.getLastPremiumDate());
	}

	@Test
	public void testgetPremiumAmountDue() throws Exception {
		MemberPolicy mem = new MemberPolicy();
		mem.setPremiumAmtDue(1000);
		assertEquals(1000, mem.getPremiumAmtDue());
	}

	@Test
	@DisplayName("to test the MemberPolicy constructor")
	public void testMemberPremiumConstructor() throws Exception {
		MemberPremium member = new MemberPremium();
	}

	/* testing for getters setters and constuctors */
	@Test
	@DisplayName("to test the claim id")
	public void testMember_Id() throws Exception {
		Members member = new Members();
		member.setMemberId(101);
		assertTrue(member.getMemberId() == 101);
	}

	@Test
	void testFirstName() {
		Members member = new Members();
		member.setFirstName("Aniket");
		assertTrue(member.getFirstName() == "Aniket");
	}

	@Test
	void testLastName() {
		Members member = new Members();
		member.setLastName("Das");
		assertTrue(member.getLastName() == "Das");
	}

	@Test
	void testAge() {
		Members member = new Members();
		member.setAge(22);
		assertTrue(member.getAge() == 22);
	}

	@Test
	void testGender() {
		Members member = new Members();
		member.setGender("Male");
		assertTrue(member.getGender() == "Male");
	}

	@Test
	public void testgetMember_Id() throws Exception {
		Members member = new Members();
		member.setMemberId(101);
		assertEquals(101, member.getMemberId());
	}

	@Test
	void testgetFirstName() {
		Members member = new Members();
		member.setFirstName("Aniket");
		assertEquals("Aniket", member.getFirstName());
	}

	@Test
	void testgetLastName() {
		Members member = new Members();
		member.setLastName("Das");
		assertEquals("Das", member.getLastName());
	}

	@Test
	void testgetAge() {
		Members member = new Members();
		member.setAge(22);
		assertEquals(22, member.getAge());
	}

	@Test
	void testgetGender() {
		Members member = new Members();
		member.setGender("Male");
		assertEquals("Male", member.getGender());
	}

	@Test
	void testgetDob() {
		Members member = new Members();
		member.setDob(new java.util.Date(1999 - 01 - 13));
		assertEquals(new java.util.Date(1999 - 01 - 13), member.getDob());
	}

	@Test
	@DisplayName("to test the MemberPolicy constructor")
	public void testMembersConstructor() throws Exception {
		Members mem = new Members();
	}

	@Test
	public void main() {
		MemberServiceApplication.main(new String[] {});
	}

}
