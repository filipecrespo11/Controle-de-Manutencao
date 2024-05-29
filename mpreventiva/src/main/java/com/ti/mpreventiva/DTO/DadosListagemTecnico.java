package com.ti.mpreventiva.DTO;

import com.ti.mpreventiva.Entities.Tecnico;

public record DadosListagemTecnico(Long id_tecnico,String login, String senha, String nome) {
	
	public DadosListagemTecnico (Tecnico tecnico) {
		this(tecnico.getId_tecnico(), tecnico.getLogin(), tecnico.getSenha(), tecnico.getNome());
	}

}