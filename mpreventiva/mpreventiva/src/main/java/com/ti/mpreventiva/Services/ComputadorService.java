package com.ti.mpreventiva.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.mpreventiva.DTO.DadosAdicionarComputador;
import com.ti.mpreventiva.DTO.DadosListagemComputador;
import com.ti.mpreventiva.DTO.DadosAtualizarComputador;
import com.ti.mpreventiva.Entities.Computador;
import com.ti.mpreventiva.Repository.ComputadorRepository;

@Service
public class ComputadorService {
	
	@Autowired
	private ComputadorRepository computadorRepository;
	
	public void adicionarComputador(DadosAdicionarComputador dados) {
		Computador computadorExistente = buscarPorServiceTag(dados.service_tag());
	    if (computadorExistente == null) {
	        Computador computador = new Computador(dados);
	        computadorRepository.save(computador);
	    } else {
	        throw new IllegalArgumentException("Já existe um computador com o mesmo Service Tag.");
	    }
    }

	public void atualizarComputador(DadosAtualizarComputador dados) {
		Computador computadorExistente = buscarPorId(dados.id_computador());
	    if (computadorExistente != null) {
	        Computador computador = computadorExistente;
	        computador.setNome_computador(dados.nome_computador());
            computador.setFabricante(dados.fabricante());
            computador.setModelo(dados.modelo());
	        computador.setService_tag(dados.service_tag());
	        computador.setPatrimonio(dados.patrimonio());
	        computador.setUnidade(dados.unidade());
	        computador.setSetor(dados.setor());
	        computador.setEstado(dados.estado());
	        computadorRepository.save(computador);
	    } else {
	    	throw new IllegalArgumentException("Computador não encontrado com o ID fornecido: " + dados.id_computador());
	    }
	}
	 
    public List<DadosListagemComputador> listarComputadores() {
        return computadorRepository.findAll().stream()
                .map(DadosListagemComputador::new)
                .collect(Collectors.toList());
    }

    public void deletarComputador(Long id_computador) {
        if (computadorRepository.existsById(id_computador)) {
            computadorRepository.deleteById(id_computador);
        }
    }
	
    public Computador buscarPorServiceTag(String service_tag) {
        return computadorRepository.buscarPorServiceTag(service_tag);
    }
    
    public Computador buscarPorId (Long id_computador) {
    	return computadorRepository.buscarPorId(id_computador);
    }

}
