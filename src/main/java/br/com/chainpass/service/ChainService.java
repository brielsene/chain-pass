package br.com.chainpass.service;

import br.com.chainpass.domain.Chain;
import br.com.chainpass.domain.dto.RequestChainDto;
import br.com.chainpass.repository.ChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ChainService {

    @Autowired
    private ChainRepository chainRepository;


    Random random = new Random();
    List<String>alfabeto = new ArrayList<>();
    List<Integer>numeros = new ArrayList<>();

    List<String>simbolos = new ArrayList<>();
    public void cadastrarPassword(RequestChainDto dados){
        Chain chain = new Chain(null, dados.senha(), LocalDateTime.now(), dados.descricao());
        chainRepository.save(chain);

    }

    public void cadastrarPasswordRandom(String descricao){
        var senha = gerarPasswordRandom();
        Chain chain = new Chain(null, senha, LocalDateTime.now(), descricao);
        chainRepository.save(chain);
    }

    public String gerarPasswordRandom(){
        String senha  = "";
        //setUps
        setUpAbcedario();
        setUpNumeros();
        setUpSimbolos();


        //formação dos 4 caracteres
        for(int i = 0; i < 4; i++){

            senha += alfabeto.get(random.nextInt(25));
        }
        for(int i = 0; i < 4; i++){

            senha += numeros.get(random.nextInt(9));
        }

        for(int i = 0; i < 4; i++){
            senha +=  simbolos.get(random.nextInt(3));

        }
        return senha = embaralhadorDeStrings(senha);
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

    public void setUpSimbolos(){
        String[] simbolosArray = {"@", "#", "&", "*"};
        simbolos.addAll(Arrays.asList(simbolosArray));
    }

    public String embaralhadorDeStrings(String senha){
        char[] caracteres = senha.toCharArray();
        String senhaPronta ="";

        List<String>caracteresList = new ArrayList<>();
        for(char caractere : caracteres){
            caracteresList.add(String.valueOf(caractere));
        }

        Collections.shuffle(caracteresList);

        for(int i = 0; i < caracteresList.size(); i++){
            senhaPronta += caracteresList.get(i);

        }
        return senhaPronta;

    }

}
