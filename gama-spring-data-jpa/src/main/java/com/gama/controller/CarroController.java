package com.gama.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gama.model.Carro;
import com.gama.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	public CarroRepository repository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Carro> incluir(@Valid @RequestBody Carro carro) {
		return ResponseEntity.ok(repository.save(carro));
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Carro> alterar(@PathVariable("id") Long id,@Valid @RequestBody Carro carro) {
		if (!repository.existsById(id)) 
			return ResponseEntity.notFound().build();
		
		carro.setId(id);
		return  ResponseEntity.ok(repository.save(carro));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		if (!repository.existsById(id)) 
			return ResponseEntity.notFound().build();
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> buscar(@PathVariable("id") Long id) {
		Optional<Carro> carroDB = repository.findById(id);

		if (carroDB.isPresent()) 
			return ResponseEntity.ok(carroDB.get());
		
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/filtro")
	public ResponseEntity<Carro> buscarPorModelo(@RequestParam("modelo") String modelo) {
		Optional<Carro> carroDB = repository.findByModelo(modelo);

		if (carroDB.isPresent()) 
			return ResponseEntity.ok(carroDB.get());
		
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<Carro> listarTodos() {
		return repository.findAll();
	}
}