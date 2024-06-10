package com.ti.mpreventiva.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfiguration implements WebMvcConfigurer {

	@Autowired
	private SecurityFilter securityFilter;

	/*
	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("GET", "PUT", "POST", "PATCH",
				"DELETE", "OPTIONS");
	}*/

	/*
	 @Bean public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource source
	  = new UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	  CorsConfiguration(); config.setAllowCredentials(true);
	  config.addAllowedOrigin("*");
	  config.addAllowedHeader("*");
	  config.addAllowedMethod("*");
	  source.registerCorsConfiguration("/**", config); return new
	  CorsFilter(source); }
	 */

	/*
	@Bean
	SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(requests -> requests
						.requestMatchers(HttpMethod.POST, "/login/user").permitAll()
						.requestMatchers(HttpMethod.GET, "/logg").permitAll()
						.anyRequest().authenticated())
						.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
	} */

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}