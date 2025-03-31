package com.ti.mpreventiva.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ti.mpreventiva.Entities.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
	
	/*@Query(value = "SELECT tecnico.nome, manutencao.chamado, manutencao.data_manutencao, computador.nome_computador, computador.fabricante, computador.modelo, computador.service_tag, computador.unidade, computador.setor, manutencao.data_manutencao_anterior, manutencao.data_manutencao_proxima, manutencao.status_manutencao, manutencao.estado ", nativeQuery = true)
	*/
	@Query(value = """
        SELECT manutencao.*
        FROM Manutencao manutencao
        LEFT JOIN manutencao.tecnico
        LEFT JOIN manutencao.computador
        ORDER BY manutencao.status_manutencao DESC
        """, nativeQuery = true)
List<Manutencao> findManutencoesComDetalhes();
	
}
/*
S	<td th:text="${manutencao.tecnico.nome}">Tecnico</td>
                <td th:text="${manutencao.chamado}">Chamado</td>
                <td th:text="${manutencao.data_manutencao}">Data</td>
                <td th:text="${manutencao.computador.nome_computador}">Nome do Micro</td>
                <td th:text="${manutencao.computador.fabricante}">Fabricante</td>
                <td th:text="${manutencao.computador.modelo}">Modelo</td>
                <td th:text="${manutencao.computador.service_tag}">Service Tag</td>
				<td th:text="${manutencao.computador.unidade}">Unidade</td>
				<td th:text="${manutencao.computador.setor}">Setor</td>
				<td th:text="${manutencao.data_manutencao_anterior}">Data da Manutencao Anterior</td>
				<td th:text="${manutencao.data_manutencao_proxima}">Data da Proxima Manutencao</td>
				<td th:text="${manutencao.status_manutencao}">Status</td>
				<td th:text="${manutencao.estado}">Estado</td> */