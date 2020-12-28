package com.rf.dio.apipessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rf.dio.apipessoa.entity.Pessoa;
import com.rf.dio.apipessoa.exceptions.PessoaNotFoundException;
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

	@Transactional(readOnly = true)
	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
	}

	@Transactional
	public void delete(Long id) {
		findById(id);
		pessoaRepository.deleteById(id);
	}

	@Transactional
	public Pessoa update(Long id, Pessoa pessoa) {
		Pessoa pessoaUpdate = findById(id);
		pessoaUpdate.setPrimeiroNome(pessoa.getPrimeiroNome());
		pessoaUpdate.setUltimoNome(pessoa.getUltimoNome());
		pessoaUpdate.setCpf(pessoa.getCpf());
		pessoaUpdate.setDataNiver(pessoa.getDataNiver());
		pessoaUpdate.setPhones(pessoa.getPhones());
		
		pessoaRepository.save(pessoaUpdate);
		return pessoaUpdate;
	}
	
}
