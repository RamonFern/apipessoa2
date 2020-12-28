package com.rf.dio.apipessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rf.dio.apipessoa.entity.Pessoa;
import com.rf.dio.apipessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private PessoaRepository pessoaRepository;
	
	@Autowired
	PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	
	public Pessoa createPessoa(Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		return pessoaSalva;
	}


	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	


}
