package com.cognizant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.RestTemplate;

import com.cognizant.helper.BenifitResult;
import com.cognizant.helper.EligibleAmt;
import com.cognizant.helper.ProviderResult;
import com.cognizant.helper.UserLoginCredential;
import com.cognizant.helper.UserToken;
import com.cognizant.models.Claims;
import com.cognizant.models.MemberPolicy;
import com.cognizant.service.AuthService;
import com.cognizant.service.MemberPortalService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberPortalController {
	@Autowired
	private MemberPortalService memberPortalService;

	@Autowired
	private AuthService auth;

	@Autowired
	private RestTemplate restTemp;

	@ExceptionHandler(BadRequest.class)
	public String handleException2(BadRequest ex, Model model) {
		model.addAttribute("message", "Session Timed Out, Login Again");
		return "redirect:login";
	}

	HttpSession session = null;

	@RequestMapping("/")
	public String mainScreen(Model model, HttpSession session) {
		model.addAttribute("title", "Home");
		session.setAttribute("token", "Invalid");
		return "login";
	}

	@RequestMapping("/session-timed-out")
	public String timedOut(Model model) {
		model.addAttribute("message", "Session Timed Out, Login Again");
		return "login";
	}

	@RequestMapping("/login-retry")
	public String loginRetry(Model model) {
		model.addAttribute("message", "username or Password is Invalid.Please retry Again");
		return "login";
	}

	@RequestMapping("/login")
	public String LogIn() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.setAttribute("token", "Invalid");
		model.addAttribute("message", "Successfully Logged Out");
		return "login";
	}

	@RequestMapping(value = "/memberHome")
	public String MemberPort(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			return "MemberHome";
		}
		return "redirect:/session-timed-out";
	}

// this method is responsible for creating token to validate a user's login
	@RequestMapping(value = "/memberHome", method = RequestMethod.POST)
	public String MemberPortal(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		UserLoginCredential creds = new UserLoginCredential();
		creds.setPassword(password);
		creds.setUserid(username);

		// creds class contains id and password variables

		ResponseEntity<UserToken> response = null;

		try {
			response = restTemp.postForEntity("http://authorizationservice/api/auth/login", creds, UserToken.class);
		} catch (Exception e) {
			log.error("Invalid credentials");
			return "redirect:/login-retry";
		}

		UserToken userToken = response.getBody();

		log.debug("token{}:", userToken.getAuthToken());
		log.debug("userToken{}: ", userToken);

		session.setAttribute("token", userToken.getAuthToken());

		log.debug("session{}:", session.toString());

		model.addAttribute("title", "Member Home");
		return "MemberHome";

	}

// this method takes user to the page where he can see his claims
	@RequestMapping("/showClaimPage")
	public String showClaimPage(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			model.addAttribute("title", "Submit Claim");
			// MemberSubmitClaim memberSubmitClaim = new MemberSubmitClaim();
			Claims memberSubmitClaim = new Claims();
			model.addAttribute("memberSubmitClaim", memberSubmitClaim);
			return "submitClaim";
		}
		return "redirect:/session-timed-out";
	}

// responsible for sending the value entered in the submit claim form to the database
	@RequestMapping(value = "/submitClaim", method = RequestMethod.POST)
	// public String submitClaim(@ModelAttribute MemberSubmitClaim
	// memberSubmitClaim, Model model, HttpSession session) {
	public String submitClaim(@ModelAttribute Claims memberSubmitClaim, Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			log.info("");
			model.addAttribute("memberSubmitClaim", memberSubmitClaim);
			//model.addAttribute("message","Id");
			memberPortalService.memberSubmitClaim(memberSubmitClaim);
			return "submitAction";
		}
		return "redirect:/session-timed-out";

	}

// redirects to the page where we can submit claims
	@GetMapping("/showClaimSubmit")
	public String showClaimSubmit(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {

			return "showClaimStatusSubmit";
		}
		return "redirect:/session-timed-out";
	}

// method that takes to the page where provider details are fetched
	@RequestMapping("/showProviderPolicySubmit")
	public String providerPolicySubmit(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			return "SubmitProviderDetails";
		}
		return "redirect:/session-timed-out";

	}

	// method to render the page to view the bill
	@RequestMapping("/showViewBillPage")
	public String showViewBillPage(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			model.addAttribute("title", "Bill");
			return "viewBillSubmit";
		}
		return "redirect:/session-timed-out";

	}

//	This method returns the current bill based on member id and policy id

	@RequestMapping(value = "/viewbill", method = RequestMethod.GET)
	public String viewBills(@RequestParam("memberId") String memberId, @RequestParam("policyId") String policyId,
			Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);

		if (valid == "True") {
			model.addAttribute("title", "View Bills");

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", token);
			HttpEntity<Boolean> requestEntity = new HttpEntity<>(null, headers);
			ResponseEntity<MemberPolicy[]> response = restTemp.exchange(
					"http://memberservice/viewBills/" + memberId + "/" + policyId, HttpMethod.GET, requestEntity,
					MemberPolicy[].class);

			MemberPolicy[] res = response.getBody();
			model.addAttribute("listBills", res);
			return "viewBills";
		}
		return "redirect:/session-timed-out";

	}

//	This method will return the status of a claim based on the policy, member and his claim id

	@RequestMapping(value = "/viewStatus", method = RequestMethod.GET)
	public String viewClaimSatus(@RequestParam("claimId") String claimId, @RequestParam("policyId") String policyId,
			@RequestParam("memberId") String memberId, Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {

			try {
				model.addAttribute("title", "View Bills");

				ResponseEntity<String> response = restTemp.getForEntity(
						"http://memberservice/getClaimStatus/" + claimId + "/" + policyId + "/" + memberId,
						String.class);
				String res = response.getBody();
				model.addAttribute("claimRes", res);
				return "showClaimStatusResult";

			} catch (Exception e) {

				return "InvalidCredential";
			}
		}
		return "redirect:/session-timed-out";

	}
//	This method will return the provider and its location based on policy id

	@RequestMapping(value = "/viewProviderDetails", method = RequestMethod.GET)
	public String providerPolicyDetails(@RequestParam("policyId") String policyId, Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			try {
				ResponseEntity<ProviderResult[]> response = restTemp
						.getForEntity("http://policyservice/getChainOfProviders/" + policyId, ProviderResult[].class);
				ProviderResult[] res = response.getBody();
				model.addAttribute("detailRes", res);
				return "showProviderResult";

			} catch (Exception e) {
				return "ProviderError";
			}
		}
		return "redirect:/session-timed-out";

	}
	@RequestMapping("/showBenifits")
	public String getBenifits(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			return "GetBenifits";
		}
		return "redirect:/session-timed-out";

	}
	@RequestMapping(value = "/viewbenifitsDetails", method = RequestMethod.GET)
	public String providerBenifit(@RequestParam("policyId") String policyId, @RequestParam("memberId") String memberId,Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			try {
				ResponseEntity<BenifitResult[]> response = restTemp
						.getForEntity("http://policyservice/getEligibleBenefits/" + policyId + "/" + memberId,BenifitResult[].class);
				BenifitResult[] res1 = response.getBody();
				model.addAttribute("detailRes", res1);
				return "GetBenifitsResult";

			} catch (Exception e) {
				return "ProviderError";
			}
		}
		return "redirect:/session-timed-out";

	}
	@RequestMapping("/showAmount")
	public String getAmount(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			return "GetAmount";
		}
		return "redirect:/session-timed-out";

	}
	@RequestMapping(value = "/viewAmountDetails", method = RequestMethod.GET)
	public String providerAmount(@RequestParam("policyId") String policyId, @RequestParam("memberId") String memberId,@RequestParam("benifitId") String benifitId,Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		String valid = auth.validateToken(token);
		if (valid == "True") {
			try {
				ResponseEntity<EligibleAmt[]> response = restTemp
						.getForEntity("http://policyservice/getEligibleClaimAmount/" + policyId + "/" + memberId+"/" + benifitId,EligibleAmt[].class);
				EligibleAmt[] res1 = response.getBody();
				model.addAttribute("detailRes", res1);
				return "GetAmountResult";

			} catch (Exception e) {
				return "ProviderError";
			}
		}
		return "redirect:/session-timed-out";

	}
	@RequestMapping("/aboutus")
	public String aboutUS() {
		return "aboutus";
	}
}
