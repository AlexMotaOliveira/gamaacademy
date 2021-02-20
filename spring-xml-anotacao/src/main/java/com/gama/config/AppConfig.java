package com.gama.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gama.model.Carro;

@Configuration
public class AppConfig {

	@Bean(name = "fiesta")
	public Carro fiesta(){
        		return new Carro("Ford", "Fiesta" , "Azul", 10);
   	}
	@Bean(name = "l200")
	public Carro l200(){
				return new Carro("Mitsubsh", "l200" , "vermelha", 10);
    	}
}

