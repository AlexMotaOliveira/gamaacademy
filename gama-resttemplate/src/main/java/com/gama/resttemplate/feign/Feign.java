package com.gama.resttemplate.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gama.resttemplate.rest.CEP;

@FeignClient(url = "https://viacep.com.br/ws" , name = "viacep")
public interface Feign {

	@GetMapping("/{cep}/json")
    CEP buscaEnderecoPor(@PathVariable("cep") String cep);
}
