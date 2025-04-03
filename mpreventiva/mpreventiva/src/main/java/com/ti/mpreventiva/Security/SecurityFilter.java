package com.ti.mpreventiva.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ti.mpreventiva.Repository.TecnicoRepository;
import com.ti.mpreventiva.Services.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
    var tokenJWT = recuperarToken(request);

    if (tokenJWT != null) {
        var subject = tokenService.getSubject(tokenJWT);
        var usuario = tecnicoRepository.findByLogin(subject);
        if (usuario.isPresent()) {
            var tecnico = usuario.get();
            var authentication = new UsernamePasswordAuthenticationToken(tecnico, null, tecnico.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    filterChain.doFilter(request, response);
			}
	
	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");
		
		if (authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ","");
			
		}
		return null;
	}
	
}
