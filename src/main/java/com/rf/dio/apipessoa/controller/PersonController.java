package com.rf.dio.apipessoa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rf.dio.apipessoa.entity.Pessoa;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PersonController {

	@GetMapping
	public String getPessoa() {
		Pessoa p = new Pessoa();
		p.setPrimeiroNome("Raul");
		p.setUltimoNome("Pedro");
		p.setCpf("32345512299");
		return "Teste API..." + p.getUltimoNome();
	}
}
