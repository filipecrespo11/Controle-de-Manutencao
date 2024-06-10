package com.ti.mpreventiva.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosAdicionarTecnico(
		Long id_tecnico,
		@NotBlank
	    String login,
	    @NotBlank
	    String senha,
	    @NotBlank
	    String nome) {
	
	
}