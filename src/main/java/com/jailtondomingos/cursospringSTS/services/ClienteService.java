package com.jailtondomingos.cursospringSTS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jailtondomingos.cursospringSTS.domain.Cliente;
import com.jailtondomingos.cursospringSTS.repositories.ClienteRepository;
import com.jailtondomingos.cursospringSTS.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	/*
	 * Jailton Domingos - Instanciando um Repository para acesso ao database
	 */
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( // Expressão Lamba para instanciamento de exception.
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
		
}

