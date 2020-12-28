package com.rf.dio.apipessoa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rf.dio.apipessoa.dto.request.PessoaDTO;
import com.rf.dio.apipessoa.entity.Pessoa;

@Component
public class PessoaMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public Pessoa toPessoa(PessoaDTO dto) {
		return MODEL_MAPPER.map(dto, Pessoa.class);
	}

	public PessoaDTO toDTO(Pessoa pessoa) {
		return MODEL_MAPPER.map(pessoa, PessoaDTO.class);
	}

	public List<PessoaDTO> toPessoaDTOList(List<Pessoa> pessoaList) {
		return pessoaList.stream().map(this::toDTO).collect(Collectors.toList());
	}

}
