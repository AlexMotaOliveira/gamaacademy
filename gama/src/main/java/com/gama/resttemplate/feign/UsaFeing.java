package com.gama.resttemplate.feign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.gama.resttemplate.rest.CEP;

@Service
public class UsaFeing {
	
	@Bean
    public CommandLineRunner run(Feign client){
        return args -> {
            if (args.length > 0) {
                String cep = "03590170";
 
                CEP endereco = client
                                     .buscaEnderecoPor(cep);
                System.out.println(endereco);
            }
        };
    }

}
