package com.rf.dio.apipessoa.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rf.dio.apipessoa.entity.Phones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String primeiroNome;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String ultimoNome;
	
	@NotEmpty
	//@CPF
	private String cpf;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDateTime dataNiver;
	
	@Valid
    @NotEmpty
	private List<Phones> phones;
}
