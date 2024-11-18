package br.com.fiap.locatech.dto;

import java.time.LocalDate;

public record AluguelRequestDTO (
        Long id,
        Long pessoaId,
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim
){
}
