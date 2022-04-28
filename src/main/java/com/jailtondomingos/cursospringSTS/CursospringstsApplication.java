package com.jailtondomingos.cursospringSTS;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jailtondomingos.cursospringSTS.domain.Categoria;
import com.jailtondomingos.cursospringSTS.repositories.CategoriaRepository;

@SpringBootApplication
public class CursospringstsApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catergoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringstsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		catergoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
	}

}
