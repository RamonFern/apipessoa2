package com.rf.dio.apipessoa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(Long id) {
	        super("Pessoa não existe com Id: " + id);
	    }

}
