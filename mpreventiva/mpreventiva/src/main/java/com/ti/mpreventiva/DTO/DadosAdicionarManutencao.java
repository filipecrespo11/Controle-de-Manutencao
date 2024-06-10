package com.ti.mpreventiva.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ti.mpreventiva.Entities.StatusManutencao;

import jakarta.validation.constraints.NotBlank;

public record DadosAdicionarManutencao(
		@NotBlank
		Long id_manutencao,
		@NotBlank
		String chamado,
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    LocalDate data_manutencao,
	    StatusManutencao status_manutencao,
	    Long id_tecnico,
	    Long id_computador
		) {

}
