package br.com.chainpass.model.dto;

import br.com.chainpass.model.Chain;

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
