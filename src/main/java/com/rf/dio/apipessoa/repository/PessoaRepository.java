package com.rf.dio.apipessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rf.dio.apipessoa.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
