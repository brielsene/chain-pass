package br.com.chainpass.service;

import br.com.chainpass.domain.dto.RequestChainDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ChainService {

    Random random = new Random();
    List<String>alfabeto = new ArrayList<>();
    List<Integer>numeros = new ArrayList<>();
    public void cadastrarPassword(RequestChainDto dados){

    }

    public String cadastrarPasswordRandom(){
        String senha  = "";
        //formação dos 4 caracteres
        for(int i = 0; i < 4; i++){
            setUpAbcedario();
            senha += alfabeto.get(random.nextInt(25));
        }
        for(int i = 0; i < 4; i++){
            setUpNumeros();
            senha += numeros.get(random.nextInt(9));
        }
        return senha;
    }

    public void setUpAbcedario(){

        // Gerando o alfabeto de A a Z
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            alfabeto.add(String.valueOf(letra));
        }
    }

    public void setUpNumeros(){
        for(int i = 0; i < 10; i++){
            numeros.add(i);
        }

    }

}
