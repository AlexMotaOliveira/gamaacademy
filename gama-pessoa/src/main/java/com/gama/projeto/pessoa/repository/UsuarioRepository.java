package com.gama.projeto.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gama.projeto.pessoa.model.Usuario;

@Repository  
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {  

	Usuario findByLogin(String login);}
