package com.jailtondomingos.cursospringSTS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jailtondomingos.cursospringSTS.domain.Categoria;
import com.jailtondomingos.cursospringSTS.domain.Estado;
import com.jailtondomingos.cursospringSTS.repositories.EstadoRepository;
import com.jailtondomingos.cursospringSTS.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	/*
	 * Jailton Domingos - Instanciando um Repository para acesso ao database
	 */
	@Autowired
	private EstadoRepository repo;
	
	public Estado find(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( // Expressão Lamba para instanciamento de exception.
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
		
}

