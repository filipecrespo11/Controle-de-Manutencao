package com.ti.mpreventiva.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ti.mpreventiva.Entities.Tecnico;
import com.ti.mpreventiva.Repository.TecnicoRepository;

@Service
public class TecnicoDetailsService implements UserDetailsService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Tentativa de autenticação para o login: " + username);
        Tecnico tecnico = tecnicoRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente ou senha inválida"));
        System.out.println("Usuário encontrado: " + tecnico.getLogin());
        System.out.println("Senha do usuário: " + tecnico.getSenha());
        return new User(tecnico.getLogin(), tecnico.getSenha(), List.of());
    }
}