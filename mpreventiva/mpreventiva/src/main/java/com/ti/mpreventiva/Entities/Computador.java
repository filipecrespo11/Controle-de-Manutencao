package com.ti.mpreventiva.Entities;

import java.io.Serializable;

import com.ti.mpreventiva.DTO.DadosAdicionarComputador;
import com.ti.mpreventiva.DTO.DadosAtualizarComputador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;


@Table(name = "Computador")
@Entity(name = "computadors")
@EqualsAndHashCode(of = "id_computador")
public class Computador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_computador;
	@NotBlank
	private String nome_computador;
	@NotBlank
	private String fabricante;
	@NotBlank
	private String modelo;
	@NotBlank
	private String service_tag;
	@NotBlank
	private String patrimonio;
	@NotBlank
	private String unidade;
	@NotBlank
	private String setor;
	@NotBlank
	private String estado; /* ENUM('ativo','inativo','consultar') NOT NULL DEFAULT ('consultar') */ 
	
	/* Construtores */
	
	public Computador() {
		
	}
	
	public Computador(Long id_computador, @NotBlank String nome_computador, @NotBlank String fabricante,
			@NotBlank String modelo, @NotBlank String service_tag, @NotBlank String patrimonio,
			@NotBlank String unidade, @NotBlank String setor, @NotBlank String estado) {
		this.id_computador = id_computador;
		this.nome_computador = nome_computador;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.service_tag = service_tag;
		this.patrimonio = patrimonio;
		this.unidade = unidade;
		this.setor = setor;
		this.estado = estado;
	}
	
	public Computador(DadosAdicionarComputador dados) {
		this.id_computador = dados.id_computador();
		this.nome_computador = dados.nome_computador();
		this.fabricante = dados.fabricante();
		this.modelo = dados.modelo();
		this.service_tag = dados.service_tag();
		this.patrimonio = dados.patrimonio();
		this.unidade = dados.unidade();
		this.setor = dados.setor();
		this.estado = dados.estado();
	}
	
	 public void AtualizarInformacoesComputador(@Valid DadosAtualizarComputador dados) {
			if (dados.nome_computador() != null) {
				this.nome_computador = dados.nome_computador();
			}
			if (dados.fabricante() != null) {
				this.fabricante = dados.fabricante();
			}
			if (dados.modelo() != null) {
				this.modelo = dados.modelo();
			}
			if (dados.service_tag() != null) {
				this.service_tag = dados.service_tag();
			}
			if (dados.patrimonio() != null) {
				this.patrimonio = dados.patrimonio();
			}
	 }
	
	/* Getters e Setters */
	
	public Long getId_computador() {
		return id_computador;
	}
	public void setId_computador(Long id_computador) {
		this.id_computador = id_computador;
	}
	public String getNome_computador() {
		return nome_computador;
	}
	public void setNome_computador(String nome_computador) {
		this.nome_computador = nome_computador;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getService_tag() {
		return service_tag;
	}
	public void setService_tag(String service_tag) {
		this.service_tag = service_tag;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
