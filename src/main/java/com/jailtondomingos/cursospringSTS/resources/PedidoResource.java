package com.jailtondomingos.cursospringSTS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jailtondomingos.cursospringSTS.domain.Pedido;
import com.jailtondomingos.cursospringSTS.services.PedidoService;

/*
 * Jailton Domingos - Arquitetura da hierarquia: Aplicação cliente > Controladores REST(Resources) > Camada de service > Camada de acesso a dados(Repository) 
 */

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String PedidoPage() {
		
		return "Pedido categorias";
	}
	
	
	/*
	 * Jailton Domingos - Instanciando um service pois é ele quem faz a conexão com o database seguindo a hierarquia do projeto
	 */
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Pedido obj = (Pedido) service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
	}
	

}
