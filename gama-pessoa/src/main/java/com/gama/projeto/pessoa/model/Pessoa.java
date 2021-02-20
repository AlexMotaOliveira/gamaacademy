package com.gama.projeto.pessoa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "campo nome não pode se nulo")
	@Size(min = 1, max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

	@NotBlank(message = "campo nome não pode se nulo")
	@Size(min = 1, max = 60)
	@Column(nullable = false, length = 60)
	private String email;

	
	@Column(nullable = false, length = 50)
	private String cpf;

	@NotBlank(message = "campo nome não pode se nulo")
	@Size(max = 10)
	@Column(nullable = false, length = 10)
	private String dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	 
}
