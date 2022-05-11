package com.jailtondomingos.cursospringSTS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jailtondomingos.cursospringSTS.domain.Cliente;
import com.jailtondomingos.cursospringSTS.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@RequestMapping(method = RequestMethod.GET)
	public String clientePage() {
		return "Página de cliente";
	}
	
	/*
	 * Instanciamento do service(Conexão com o database)
	 */
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
