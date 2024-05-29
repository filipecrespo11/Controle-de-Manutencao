package com.ti.mpreventiva.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosAdicionarComputador(
		Long id_computador,
		@NotBlank
		String nome_computador,
		@NotBlank
		String fabricante,
		@NotBlank
		String modelo,
		@NotBlank
		String service_tag,
		@NotBlank
		String patrimonio,
		@NotBlank
		String unidade,
		@NotBlank
		String setor,
		@NotBlank
		String estado
		) {

}
