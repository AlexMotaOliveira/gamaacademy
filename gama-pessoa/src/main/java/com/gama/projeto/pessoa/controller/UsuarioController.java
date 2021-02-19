package com.gama.projeto.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.projeto.pessoa.model.Usuario;
import com.gama.projeto.pessoa.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
		 usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.saveAndFlush(usuario));
	}
}