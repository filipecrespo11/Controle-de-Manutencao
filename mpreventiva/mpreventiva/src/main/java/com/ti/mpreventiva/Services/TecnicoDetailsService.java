package com.ti.mpreventiva.Services;
import org.springframework.context.annotation.Primary;
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
@Primary
public class TecnicoDetailsService implements UserDetailsService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Tecnico tecnico = tecnicoRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente ou senha inválida"));
        return new User(tecnico.getLogin(), tecnico.getSenha(), List.of());
    }
}