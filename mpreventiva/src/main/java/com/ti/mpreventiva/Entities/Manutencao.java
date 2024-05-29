package com.ti.mpreventiva.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.ti.mpreventiva.DTO.DadosAdicionarManutencao;
import com.ti.mpreventiva.DTO.DadosAtualizarManutencao;
import com.ti.mpreventiva.DTO.StatusManutencao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;


@Table(name = "Manutencao")
@Entity(name = "manutencaos")
@EqualsAndHashCode(of = "id_manutencao")
public class Manutencao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_manutencao;

	@NotNull
	@Column(name = "chamado")
	private int chamado;
    
	@Column(name = "data_manutencao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_manutencao;
    
    @Column(name = "data_manutencao_anterior")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_manutencao_anterior;
    
    @Column(name = "data_manutencao_proxima")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_manutencao_proxima;
   
    @Enumerated(EnumType.STRING)
    @Column(name = "status_manutencao")
    private StatusManutencao status_manutencao;
    
    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;
    
    @ManyToOne
    @JoinColumn(name = "id_computador")
    private Computador computador;
	
	/* Construtores */
	
	public Manutencao() {
		
	}
	
	public Manutencao(Long id_manutencao, @NotBlank int chamado, @NotBlank LocalDate data_manutencao,
			LocalDate data_manutencao_anterior, LocalDate data_manutencao_proxima, StatusManutencao status_manutencao,
			Tecnico tecnico, Computador computador) {
		this.id_manutencao = id_manutencao;
		this.chamado = chamado;
		this.data_manutencao = data_manutencao;
		this.data_manutencao_anterior = data_manutencao_anterior;
		this.data_manutencao_proxima = data_manutencao_proxima;
		this.status_manutencao = status_manutencao;
		this.tecnico = tecnico;
		this.computador = computador;
	}
	
	public Manutencao (@Valid DadosAdicionarManutencao dados, Tecnico tecnico, Computador computador) {
		this.id_manutencao = dados.id_manutencao();
        this.chamado = dados.chamado();
        this.data_manutencao = dados.data_manutencao();
        this.status_manutencao = dados.status_manutencao();
        this.tecnico = tecnico;
        this.computador = computador;
	}
	
	public void AtualizarInformacoesManutencao (@Valid DadosAtualizarManutencao dados) {
		this.chamado = dados.chamado();
		this.data_manutencao = dados.data_manutencao();
		this.status_manutencao  = dados.status_manutencao();	
	}
	
	
	/* Getters e Setters */
	
	public Long getId_manutencao() {
		return id_manutencao;
	}

	public void setId_manutencao(Long id_manutencao) {
		this.id_manutencao = id_manutencao;
	}

	public int getChamado() {
		return chamado;
	}

	public void setChamado(int chamado) {
		this.chamado = chamado;
	}

	public LocalDate getData_manutencao() {
		return data_manutencao;
	}

	public void setData_manutencao(LocalDate data_manutencao) {
		this.data_manutencao = data_manutencao;
	}

	public LocalDate getData_manutencao_anterior() {
		return data_manutencao_anterior;
	}

	public void setData_manutencao_anterior(LocalDate data_manutencao_anterior) {
		this.data_manutencao_anterior = data_manutencao_anterior;
	}

	public LocalDate getData_manutencao_proxima() {
		return data_manutencao_proxima;
	}

	public void setData_manutencao_proxima(LocalDate data_manutencao_proxima) {
		this.data_manutencao_proxima = data_manutencao_proxima;
	}

	public StatusManutencao getStatus_manutencao() {
		return status_manutencao;
	}

	public void setStatus_manutencao(StatusManutencao status_manutencao) {
		this.status_manutencao = status_manutencao;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Computador getComputador() {
		return computador;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}
}
