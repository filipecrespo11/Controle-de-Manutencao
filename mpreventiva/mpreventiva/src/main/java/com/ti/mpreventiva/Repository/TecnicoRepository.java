package com.ti.mpreventiva.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ti.mpreventiva.Entities.Tecnico;


@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	
	Optional<Tecnico> findByLogin(String login);
	
	@Query(value = "SELECT * FROM tecnico WHERE nome = ?1", nativeQuery = true)
	Optional<Tecnico> buscarPorNome(String nome);

}
