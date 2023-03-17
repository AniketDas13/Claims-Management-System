package com.cognizant.service;

import org.springframework.stereotype.Service;

import com.cognizant.models.Claims;

@Service
public interface MemberPortalService {
	void memberSubmitClaim(Claims memberSubmitClaim);

}
