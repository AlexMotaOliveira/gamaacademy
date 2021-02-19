package com.gama.projeto.pessoa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gama.projeto.pessoa.model.Pessoa;
import com.gama.projeto.pessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	public PessoaRepository pessoaRepository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Pessoa> incluir(@Valid @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaRepository.save(pessoa));
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Pessoa> alterar(@PathVariable("id") Long id, @Valid @RequestBody Pessoa pessoa) {
		if (!pessoaRepository.existsById(id))
			return ResponseEntity.notFound().build();

		pessoa.setId(id);
		return ResponseEntity.ok(pessoaRepository.save(pessoa));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		if (!pessoaRepository.existsById(id))
			return ResponseEntity.notFound().build();

		pessoaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscar(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoaDB = pessoaRepository.findById(id);

		if (pessoaDB.isPresent())
			return ResponseEntity.ok(pessoaDB.get());

		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}
}
