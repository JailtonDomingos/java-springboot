package com.jailtondomingos.cursospringSTS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jailtondomingos.cursospringSTS.domain.Pedido;
import com.jailtondomingos.cursospringSTS.repositories.PedidoRepository;
import com.jailtondomingos.cursospringSTS.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	/*
	 * Jailton Domingos - Instanciando um Repository para acesso ao database
	 */
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( // Expressão Lamba para instanciamento de exception.
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
		
}

