package com.jailtondomingos.cursospringSTS.repositories;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jailtondomingos.cursospringSTS.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>  {

}
