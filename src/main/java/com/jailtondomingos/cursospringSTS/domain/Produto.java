package com.jailtondomingos.cursospringSTS.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preço;
	
	/*
	 * Usa-se o JsonReference e JsonBackReference para não acontecer uma referencia cíclica entre tabelas conectadas por referencia.
	 * JsonBackReference verifica se já existe serialização Json no outro lado.
	 */
	@JsonBackReference
	@ManyToMany
	@JoinTable(	name = "PRODUTO_CATEGORIA", 								// Tabela que fará o mapeamento da ligação entre Gategoria e Produto
				joinColumns = @JoinColumn(name = "produto_id"), 			// FK da tabela Produto
				inverseJoinColumns = @JoinColumn(name = "categoria_id") 	// FK da tabela Categoria
			)
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonBackReference
	@ManyToOne
	private Pedido pedido;
	
	public Produto() {
		
	}

	public Produto(Integer id, String nome, Double preço) {
		super();
		this.id = id;
		this.nome = nome;
		this.preço = preço;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
