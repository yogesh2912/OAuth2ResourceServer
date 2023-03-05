package com.yogesh.OAuth2ClientCredentials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.csrf().disable()
			.authorizeHttpRequests()
			//.requestMatchers("/content").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
		
		
		
		// niche ka do if we do form based login 
		// http.httpBasic();
		// http.formLogin();
		
		return http.build();
	}

}
