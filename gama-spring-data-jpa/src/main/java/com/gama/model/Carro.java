package com.gama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "campo marca nao pode se nulo")
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String marca;
	
	@NotEmpty(message = "campo modelo nao pode se nulo")
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String modelo;
	
	@NotEmpty(message = "campo cor nao pode se nulo")
	@Size(min = 1, max = 20)
	@Column(nullable = false, length = 20)
	private String cor;
	
	@Min(1)
	@Max(100)
	@Column(nullable = false)
	private Integer combustivel;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}	
}
