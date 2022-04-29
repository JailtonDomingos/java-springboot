package com.jailtondomingos.cursospringSTS.repositories;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jailtondomingos.cursospringSTS.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>  {

}

