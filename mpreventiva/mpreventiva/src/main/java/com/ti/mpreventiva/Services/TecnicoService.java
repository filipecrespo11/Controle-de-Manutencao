package com.ti.mpreventiva.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.mpreventiva.DTO.DadosAdicionarTecnico;
import com.ti.mpreventiva.DTO.DadosAtualizarTecnico;
import com.ti.mpreventiva.DTO.DadosListagemTecnico;
import com.ti.mpreventiva.Entities.Tecnico;
import com.ti.mpreventiva.Repository.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	public void adicionarTecnico(DadosAdicionarTecnico dados) {
		Tecnico tecnicoExistente = buscarPorNome(dados.nome());
		if (tecnicoExistente == null) {
			Tecnico tecnico = new Tecnico(dados);
			tecnicoRepository.save(tecnico);
		} else {
			throw new IllegalArgumentException("Já existe um técnico com esse nome.");
		}
	}

	public void atualizarTecnico(DadosAtualizarTecnico dados) {
		Tecnico tecnicoExistente = buscarPorNome(dados.nome());
		if (tecnicoExistente != null) {
			tecnicoExistente.AtualizarInformacoesTecnico(dados);
			tecnicoRepository.save(tecnicoExistente);
		} else {
			throw new IllegalArgumentException("Tecnico nao encontrado com o nome fornecido");
		}
	}

	public void deletarTecnico(Long id_tecnico) {
		if (tecnicoRepository.existsById(id_tecnico)) {
			tecnicoRepository.deleteById(id_tecnico);
		} else {
			throw new IllegalArgumentException("Tecnico nao encontrado com o ID fornecido");
		}
	}

	public Tecnico buscarPorNome(String nome) {
		return tecnicoRepository.buscarPorNome(nome);
	}

	public List<DadosListagemTecnico> listarTecnicos() {
		return tecnicoRepository.findAll().stream().map(DadosListagemTecnico::new).collect(Collectors.toList());
	}
}
