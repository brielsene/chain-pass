package br.com.chainpass.domain.dto;

import br.com.chainpass.domain.Chain;

import java.time.LocalDateTime;

public record ResponseChainDto(
        Long id,
        String senha,
        LocalDateTime data,
        String descricao
) {
    public ResponseChainDto(Chain chain){
        this(chain.getId(), chain.getSenha(), chain.getData(), chain.getDescricao());
    }

}
