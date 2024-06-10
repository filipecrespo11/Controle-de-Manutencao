package com.ti.mpreventiva.DTO;

import com.ti.mpreventiva.Entities.Computador;

public record DadosListagemComputador(Long id_computador, String nome_computador, String fabricante, String modelo, 
										String service_tag, String patrimonio, String unidade, String setor, String estado) {
	
	public DadosListagemComputador(Computador computador) {
		this(computador.getId_computador(), computador.getNome_computador(), computador.getFabricante(), computador.getModelo(), 
				computador.getService_tag(), computador.getPatrimonio(), computador.getUnidade(), computador.getSetor(), computador.getEstado());
	}

}
