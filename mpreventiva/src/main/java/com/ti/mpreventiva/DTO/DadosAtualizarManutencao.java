package com.ti.mpreventiva.DTO;

import java.time.LocalDate;

public record DadosAtualizarManutencao(Long id_manutencao, int chamado, LocalDate data_manutencao, StatusManutencao status_manutencao) {

}
