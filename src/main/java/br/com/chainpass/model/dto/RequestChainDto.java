package br.com.chainpass.model.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestChainDto(
        @NotBlank
        String senha,
        String descricao

) {

}
