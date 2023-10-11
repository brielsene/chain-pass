package br.com.chainpass.controller;

import br.com.chainpass.model.dto.RequestChainDto;
import br.com.chainpass.model.dto.RequestPassDto;
import br.com.chainpass.model.dto.ResponseChainDto;
import br.com.chainpass.service.ChainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chainpass")
public class ChainController {

    @Autowired
    private ChainService chainService;


    @PostMapping
    public ResponseEntity cadastrarSenha(@RequestBody @Valid RequestChainDto dados){
        chainService.cadastrarPassword(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/random")
    public ResponseEntity cadastrarSenhaRandom(@RequestBody RequestPassDto dados){
        chainService.cadastrarPasswordRandom(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public ResponseEntity<List<ResponseChainDto>> listaTodasPass(){
        return ResponseEntity.status(HttpStatus.OK).body(chainService.listaSenhas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseChainDto>detalhaPass(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(chainService.detalhaSenhaPorId(id));
    }
}
