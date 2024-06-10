package com.ti.mpreventiva.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ti.mpreventiva.Entities.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	
	UserDetails findByLogin(String login);
	
	@Query(value = "SELECT * FROM tecnico WHERE nome = ?1", nativeQuery = true)
	Tecnico buscarPorNome(String nome);

}
