package br.com.chainpass.controller;

import br.com.chainpass.infra.security.TokenService;
import br.com.chainpass.model.Usuario;
import br.com.chainpass.model.dto.DtoLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody DtoLogin dados){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        return ResponseEntity.status(HttpStatus.OK).body(tokenService.gerarToken(usuario));
    }
}
