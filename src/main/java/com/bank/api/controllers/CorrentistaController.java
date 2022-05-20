package com.bank.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.dto.correntista.NovoCorrentistaDto;
import com.bank.api.models.Correntista;
import com.bank.api.repositories.CorrentistaRepository;
import com.bank.api.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	@Autowired
	private CorrentistaService correntistaService;
	
	@GetMapping
	public List<Correntista> findAll(){
		return correntistaRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentistaDto novoCorrentistaDto) {
		correntistaService.save(novoCorrentistaDto);
	}
}
