package com.yogesh.OAuth2ClientCredentials.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

	@GetMapping("/content")
	public String contentController(Authentication auth) {
		
		return	auth.getAuthorities().toString();
		//return auth.getPrincipal().
	}
}
