package com.ti.mpreventiva.Controllers.APIRest;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.mpreventiva.DTO.DadosAutenticacao;
import com.ti.mpreventiva.Security.SecurityConfiguration;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	 @Autowired
	 private AuthenticationManager authenticationManager;

	 @Autowired
	 private UserDetailsService userDetailsService;

	 @Autowired
	 private PasswordEncoder passwordEncoder;

	 @Autowired
	 @Lazy
	 private SecurityConfiguration securityConfiguration;

	
	@PostMapping("/login")
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = authenticationManager.authenticate(token);
		return ResponseEntity.ok().build();
	}
}
