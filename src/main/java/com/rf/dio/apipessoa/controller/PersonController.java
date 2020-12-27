package com.rf.dio.apipessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.dio.apipessoa.dto.response.MessageResponseDTO;
import com.rf.dio.apipessoa.entity.Pessoa;
import com.rf.dio.apipessoa.service.PessoaService;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PersonController {
	
	private PessoaService pessoaService;
	

	@Autowired
	PersonController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.createPessoa(pessoa);
	}
}
