package com.jailtondomingos.cursospringSTS.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jailtondomingos.cursospringSTS.domain.Categoria;
import com.jailtondomingos.cursospringSTS.services.CategoriaService;

/*
 * Jailton Domingos - Arquitetura da hierarquia: Aplicação cliente > Controladores REST > Camada de service > Camada de acesso a dados(Repository) 
 */

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String categoriasPage() {
		
		return "Pagina categorias";
	}
	
	
	/*
	 * Jailton Domingos - Instanciando um service pois é ele quem faz a conexão com o database seguindo a hierarquia do projeto
	 */
	@Autowired
	private CategoriaService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
