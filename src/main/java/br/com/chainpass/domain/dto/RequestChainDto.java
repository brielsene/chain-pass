package br.com.chainpass.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RequestChainDto(

        String senha,
        String descricao

) {

}
