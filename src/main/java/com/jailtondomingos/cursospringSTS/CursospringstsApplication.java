package com.jailtondomingos.cursospringSTS;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jailtondomingos.cursospringSTS.domain.Categoria;
import com.jailtondomingos.cursospringSTS.domain.Cidade;
import com.jailtondomingos.cursospringSTS.domain.Cliente;
import com.jailtondomingos.cursospringSTS.domain.Endereco;
import com.jailtondomingos.cursospringSTS.domain.Estado;
import com.jailtondomingos.cursospringSTS.domain.Pedido;
import com.jailtondomingos.cursospringSTS.domain.Produto;
import com.jailtondomingos.cursospringSTS.domain.enums.TipoCliente;
import com.jailtondomingos.cursospringSTS.repositories.CategoriaRepository;
import com.jailtondomingos.cursospringSTS.repositories.CidadeRepository;
import com.jailtondomingos.cursospringSTS.repositories.ClienteRepository;
import com.jailtondomingos.cursospringSTS.repositories.EnderecoRepository;
import com.jailtondomingos.cursospringSTS.repositories.EstadoRepository;
import com.jailtondomingos.cursospringSTS.repositories.PedidoRepository;
import com.jailtondomingos.cursospringSTS.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringstsApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catergoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringstsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Inform??tica");
		Categoria cat2 = new Categoria(null, "Escrit??rio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		catergoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		/* ------------- */		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "S??o Paulo");
		
		Cidade c1 = new Cidade(null, "Uberl??ndia", est1);
		Cidade c2 = new Cidade(null, "S??o Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);	
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		/* ------------- */	
		
		Cliente cli1 = new Cliente(null, "Jailton Domingos", "Development.j@outlook.com", "99999999999", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("47991343216", "47991323416"));
		
		Cliente cli2 = new Cliente(null, "Caroline Domingos", "carol@gmail.com", "99999999999", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("47999999999", "47999999999"));

		Endereco e1 = new Endereco(null, "Rua Paraguai", "300", "Apto 303", "Jardim", "89082160", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Uruguai", "150", "Apto 150", "Botanico", "89082879", cli1, c2);
		Endereco e3 = new Endereco(null, "Rua Chile", "99", "Apto 20", "Azul", "89082855", cli2, c3);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		
		
		Pedido ped1 = new Pedido(null, 111);
		ped1.setCliente(cli1);
		Pedido ped2 = new Pedido(null, 222);
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
	}

}
