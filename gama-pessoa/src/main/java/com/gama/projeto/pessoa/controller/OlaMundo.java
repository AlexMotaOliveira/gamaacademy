package com.gama.projeto.pessoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OlaMundo {
	
	@RequestMapping("/ola")
	@ResponseBody
	public String ola () {
		return "Bom dia, Otimo sabado para todoss :)";
		
	}

}
