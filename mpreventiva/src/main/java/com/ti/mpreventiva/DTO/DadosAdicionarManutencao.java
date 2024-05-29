package com.ti.mpreventiva.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAdicionarManutencao(
		@NotBlank
		Long id_manutencao,
		@NotNull
	    int chamado,
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    LocalDate data_manutencao,
	    StatusManutencao status_manutencao,
	    Long id_tecnico,
	    Long id_computador
		) {

}
