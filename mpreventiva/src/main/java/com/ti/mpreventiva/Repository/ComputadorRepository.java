package com.ti.mpreventiva.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ti.mpreventiva.Entities.Computador;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Long> {
	
	@Query(value = "SELECT * FROM computador WHERE service_tag = ?1", nativeQuery = true)
	Computador buscarPorServiceTag(String service_tag);
	
	@Query(value = "SELECT * FROM computador WHERE id_computador = ?1", nativeQuery = true)
	Computador buscarPorId(Long id_computador);
	
	@Query(value = "SELECT * FROM computador WHERE service_tag = ?1 AND id_computador = ?1", nativeQuery = true)
	Computador buscarPorServiceTagEId(String service_tag, Long id_computador);
	
	/*
	Computador  buscarPorServiceTagEId(String service_tag, Long id_computador);
    */

}
