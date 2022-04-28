package com.jailtondomingos.cursospringSTS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jailtondomingos.cursospringSTS.domain.Categoria;
import com.jailtondomingos.cursospringSTS.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	/*
	 * Jailton Domingos - Instanciando um Repository para acesso ao database
	 */
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	
}
