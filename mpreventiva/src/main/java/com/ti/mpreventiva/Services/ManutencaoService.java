package com.ti.mpreventiva.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.mpreventiva.DTO.DadosAdicionarManutencao;
import com.ti.mpreventiva.DTO.DadosAtualizarManutencao;
import com.ti.mpreventiva.Entities.Computador;
import com.ti.mpreventiva.Entities.Manutencao;
import com.ti.mpreventiva.Entities.Tecnico;
import com.ti.mpreventiva.Repository.ComputadorRepository;
import com.ti.mpreventiva.Repository.ManutencaoRepository;
import com.ti.mpreventiva.Repository.TecnicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {

	@Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ComputadorRepository computadorRepository;

    public Manutencao adicionarManutencao(DadosAdicionarManutencao dados) {
        Optional<Tecnico> tecnicoOptional = tecnicoRepository.findById(dados.id_tecnico());
        Optional<Computador> computadorOptional = computadorRepository.findById(dados.id_computador());

        if (tecnicoOptional.isEmpty() || computadorOptional.isEmpty()) {
            throw new RuntimeException("Técnico ou computador não encontrado!");
        }

        Tecnico tecnico = tecnicoOptional.get();
        Computador computador = computadorOptional.get();

        Manutencao manutencao = new Manutencao(dados, tecnico, computador);
        return manutencaoRepository.save(manutencao);
    }

    public Manutencao atualizarManutencao(Long id_manutencao, DadosAtualizarManutencao dados) {
        Optional<Manutencao> optionalManutencao = manutencaoRepository.findById(id_manutencao);
        if (optionalManutencao.isPresent()) {
            Manutencao manutencao = optionalManutencao.get();
            manutencao.AtualizarInformacoesManutencao(dados);
            return manutencaoRepository.save(manutencao);
        } else {
            throw new RuntimeException("Manutencao não encontrada!");
        }
    }
    
    public Manutencao buscarPorId(Long id_manutencao) {
        Optional<Manutencao> optionalManutencao = manutencaoRepository.findById(id_manutencao);
        return optionalManutencao.orElse(null);
    }
    
    

    public void deletarManutencao(Long id_manutencao) {
        manutencaoRepository.deleteById(id_manutencao);
    }

    public List<Manutencao> listarManutencoes() {
        return manutencaoRepository.findAll();
    }

	public List<Manutencao> listarManutencoesFront() {
		return manutencaoRepository.findAll();
	}
}
