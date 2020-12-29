package com.toystore.ecomm.ptms.daorepo.model.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	/*
	 * public User getCurrentAuditor() {
	 * 
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * if (authentication == null || !authentication.isAuthenticated()) { return
	 * null; }
	 * 
	 * return ((MyUserDetails) authentication.getPrincipal()).getUser(); }
	 */

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("ptms-service");
		// Use below commented code when will use Spring Security.
	}
}
