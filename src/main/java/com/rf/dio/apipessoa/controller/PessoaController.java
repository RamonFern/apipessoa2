package com.rf.dio.apipessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.dio.apipessoa.dto.request.PessoaDTO;
import com.rf.dio.apipessoa.entity.Pessoa;
import com.rf.dio.apipessoa.mapper.PessoaMapper;
import com.rf.dio.apipessoa.service.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {
	

	private final PessoaService pessoaService;
	private final PessoaMapper pessoaMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PessoaDTO> createPessoa(@RequestBody PessoaDTO dto) {
		var pessoaCriada = pessoaMapper.toPessoa(dto);
		var createPessoa = pessoaService.createPessoa(pessoaCriada);
		PessoaDTO pessoaDTO = pessoaMapper.toDTO(createPessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoaAtualizada = pessoaMapper.toPessoa(pessoaDTO);
		Pessoa pessoa = pessoaService.update(id, pessoaAtualizada);
		return ResponseEntity.ok(pessoaMapper.toDTO(pessoa));
	}
		
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<Pessoa> pessoaList = pessoaService.findAll();
		List<PessoaDTO> pessoaDTOList = pessoaMapper.toPessoaDTOList(pessoaList);
		return ResponseEntity.ok(pessoaDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.findById(id);
		PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);
		return ResponseEntity.ok(pessoaDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
