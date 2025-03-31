package com.ti.mpreventiva.Controllers.APIRest;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.ti.mpreventiva.DTO.DadosTokenJWT;
import com.ti.mpreventiva.Entities.Tecnico;
import com.ti.mpreventiva.Security.SecurityConfiguration;
import com.ti.mpreventiva.Services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	 @Autowired
	 private AuthenticationManager authenticationManager;

	 @Autowired
	 @Qualifier("tecnicoDetailsService")
	 private UserDetailsService userDetailsService;

	 @Autowired
	 private PasswordEncoder passwordEncoder;

	 @Autowired
	 private TokenService tokenService; 
	 
	 @Autowired
	 @Lazy
	 private SecurityConfiguration securityConfiguration;

	
	 @PostMapping("/user")
	 public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		 System.out.println("Tentativa de login com login: " + dados.login());
		 var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		 var autenticacao = authenticationManager.authenticate(token);
		 System.out.println("Autenticação bem-sucedida para login: " + dados.login());
		 var tokenJWT = tokenService.gerarToken((Tecnico) autenticacao.getPrincipal());
		 System.out.println("Token gerado: " + tokenJWT);
		 return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	 }
}
