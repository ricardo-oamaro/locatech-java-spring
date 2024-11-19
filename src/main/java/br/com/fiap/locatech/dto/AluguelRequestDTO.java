package br.com.fiap.locatech.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO (
        Long id,
        @NotNull(message = "O id da pessoa é obrigatório")
        Long pessoaId,
        @NotNull(message = "O id do veículo é obrigatório")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim
){
}
