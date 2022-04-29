package com.jailtondomingos.cursospringSTS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jailtondomingos.cursospringSTS.domain.Estado;
import com.jailtondomingos.cursospringSTS.services.EstadoService;

/*
 * Jailton Domingos - Arquitetura da hierarquia: Aplicação cliente > Controladores REST(Resources) > Camada de service > Camada de acesso a dados(Repository) 
 */

@RestController
@RequestMapping(value="/estado")
public class EstadoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String EstadoPage() {
		
		return "Estado categorias";
	}
	
	
	/*
	 * Jailton Domingos - Instanciando um service pois é ele quem faz a conexão com o database seguindo a hierarquia do projeto
	 */
	@Autowired
	private EstadoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Estado obj = (Estado) service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
	}
	

}
