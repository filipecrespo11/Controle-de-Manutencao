
package com.ti.mpreventiva.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ti.mpreventiva.Repository.TecnicoRepository;
@Primary
@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var tecnico = tecnicoRepository.findByLogin(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    return new org.springframework.security.core.userdetails.User(
            tecnico.getLogin(),
            tecnico.getSenha(),
            List.of() // Adicione as permissões/authorities aqui, se necessário
    );}

}