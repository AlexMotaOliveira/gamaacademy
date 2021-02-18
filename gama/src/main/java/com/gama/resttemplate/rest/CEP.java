package com.gama.resttemplate.rest;


public class CEP {

	String cep;
	String logradouro;
	String bairro;
	String localidade;
	String uf;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getuF() {
		return uf;
	}

	public void setuF(String uF) {
		this.uf = uF;
	}

	@Override
	public String toString() {
		return "CEP [cep=" + cep + ", logradouro=" + logradouro + ", " + ", bairro=" + bairro + ", localidade="
				+ localidade + ", uf=" + uf + "]";
	}

}
