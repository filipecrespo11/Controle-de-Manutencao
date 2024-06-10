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

import com.ti.mpreventiva.DTO.DadosAdicionarComputador;
import com.ti.mpreventiva.DTO.DadosAtualizarComputador;
import com.ti.mpreventiva.DTO.DadosListagemComputador;
import com.ti.mpreventiva.Services.ComputadorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/computador")
public class ComputadorRestController {

	  @Autowired
	  private ComputadorService computadorService;

	  @PostMapping("/add")
	  @Transactional
	  public ResponseEntity<Void> addComputador(@RequestBody @Valid DadosAdicionarComputador dados) {
	      computadorService.adicionarComputador(dados);
	      return ResponseEntity.status(HttpStatus.CREATED).build();
	  }

	  @PutMapping("/update/{id_computador}")
	  @Transactional
	  public ResponseEntity<Void> attComputador(@PathVariable Long id_computador, @RequestBody @Valid DadosAtualizarComputador dados) {
	      computadorService.atualizarComputador(dados);
	      return ResponseEntity.ok().build();
	  }

	  @GetMapping("/list")
	  @Transactional
	  public ResponseEntity<List<DadosListagemComputador>> listaDeComputador() {
	      List<DadosListagemComputador> computadores = computadorService.listarComputadores();
	      return ResponseEntity.ok(computadores);
	  }

	  @DeleteMapping("/delete/{id_computador}")
	  @Transactional
	  public ResponseEntity<Void> deletarComputador(@PathVariable Long id_computador) {
	      computadorService.deletarComputador(id_computador);
	      return ResponseEntity.noContent().build();
	  }
}
