package com.ti.mpreventiva.Controllers.APIRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.mpreventiva.DTO.DadosAdicionarTecnico;
import com.ti.mpreventiva.DTO.DadosAtualizarTecnico;
import com.ti.mpreventiva.DTO.DadosListagemTecnico;
import com.ti.mpreventiva.Services.TecnicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tecnico")
public class TecnicoRestController {

	@Autowired
	private TecnicoService tecnicoService;

	@PostMapping("/add")
	@Transactional
	public ResponseEntity<Void> addTecnico(@RequestBody @Valid DadosAdicionarTecnico dados) {
		tecnicoService.adicionarTecnico(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/update/{id_tecnico}")
	@Transactional
	public ResponseEntity<Void> updateTecnico(@PathVariable Long id_tecnico,
			@RequestBody @Valid DadosAtualizarTecnico dados) {
		tecnicoService.atualizarTecnico(dados);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/list")
	@Transactional
	public ResponseEntity<List<DadosListagemTecnico>> ListaDeTecnicos() { 
		List<DadosListagemTecnico> tecnicos = tecnicoService.listarTecnicos();
		return ResponseEntity.ok(tecnicos);
	}

	@DeleteMapping("/delete/{id_tecnico}")
	@Transactional
	public ResponseEntity<Void> deletarTecnico(@PathVariable Long id_tecnico) {
		tecnicoService.deletarTecnico(id_tecnico);
		return ResponseEntity.noContent().build();
	}

	/*
	@GetMapping("/find/{id_tecnico}")
	@Transactional
	public ResponseEntity<DadosListagemTecnico> findTecnico(@PathVariable Long id_tecnico) {
		var tecnico = tecnicoRepository.findById(id_tecnico);
		return tecnico.map(value -> ResponseEntity.ok(new DadosListagemTecnico(value)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	*/
}