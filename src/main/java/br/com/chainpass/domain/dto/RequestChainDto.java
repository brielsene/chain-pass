package br.com.chainpass.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RequestChainDto(
        @NotBlank
        String senha,
        String descricao

) {

}
