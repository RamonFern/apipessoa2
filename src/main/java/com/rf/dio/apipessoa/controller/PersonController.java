package com.rf.dio.apipessoa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PersonController {

	@GetMapping
	public String getPessoa() {
		return "Teste API...";
	}
}
