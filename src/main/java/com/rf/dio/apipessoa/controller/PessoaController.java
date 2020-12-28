package com.rf.dio.apipessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.dio.apipessoa.dto.request.PessoaDTO;
import com.rf.dio.apipessoa.mapper.PessoaMapper;
import com.rf.dio.apipessoa.service.PessoaService;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {
	

	private final PessoaService pessoaService;
	private final PessoaMapper pessoaMapper;
	
	

	@Autowired
	PessoaController(PessoaService pessoaService, PessoaMapper pessoaMapper) {
		this.pessoaService = pessoaService;
		this.pessoaMapper = pessoaMapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PessoaDTO> createPessoa(@RequestBody PessoaDTO dto) {
		var pessoaCriada = pessoaMapper.toPessoa(dto);
		var createPessoa = pessoaService.createPessoa(pessoaCriada);
		PessoaDTO pessoaDTO = pessoaMapper.toDTO(createPessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
	}
}
