package com.jailtondomingos.cursospringSTS.repositories;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jailtondomingos.cursospringSTS.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>  {

}
