package br.com.chainpass;

import br.com.chainpass.service.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChainPassApplication implements CommandLineRunner {
	@Autowired
	private ChainService service;

	public static void main(String[] args) {
		SpringApplication.run(ChainPassApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String senha = service.cadastrarPasswordRandom();
		System.out.println(senha);
	}
}
