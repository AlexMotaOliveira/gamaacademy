package com.gama.projeto.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.projeto.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findByCpf(String cpf);

	Pessoa findByNome(String nome);

	Pessoa findByEmail(String email);
}
